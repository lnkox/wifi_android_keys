#include <ESP8266WiFi.h>
#include <WiFiUdp.h>
#include <EEPROM.h>
#include <ArduinoJson.h>
#include <Ticker.h>
#include <PubSubClient.h>

WiFiUDP Udp;
Ticker timers;
WiFiClient wclient;






const byte button_pin = D2; // пін для апаратної кнопки зміни режиму
const byte clk_pin = D1;
const byte data_pin = D5;
const byte sb_pin = D6;
unsigned int localUdpPort = 2201; // Порт для прослуховання

char modes = 0; //тип зєднання пристрою
char but_state[33]; // стан кнопок
char incomingPacket[255];  // Буфер для пакету UDP
char ap_but = 0;
int mqtt_conect_tout = 2;


struct butn_st
{
  char txt[60];
  boolean lock;
};
butn_st butnn[32];

struct eeprom_dinfo {
  char firts_run;
  char name_dev[15];
  char ssid_ap[15];
  char pass_ap[15];
  char ssid_sta[15];
  char pass_sta[15];
  char mqttserver[40];
  long int  mqttport;
  char mqttlogin[30];
  char mqttpass[30];
  boolean stmode;
  boolean hide_ssid;
  char font_size;
  char v_size;
  char h_size;
};

eeprom_dinfo dinfo;



void  get_name(void);
void proces_json(char *json_data);
void get_key(int ind);
void  get_name(void);
void  send_saveok(void);
void  get_apset(void);
void  get_staset(void);
void send_to_mk(char ind, boolean state);

void callback(char* topic, byte* payload, unsigned int length);

PubSubClient mqttclient("server", 123, callback, wclient);



//////////////////////////////////////////////////////////////////
//Логіка
//////////////////////////////////////////////////////////////////
void proces_json(char *json_data)
{
  char tmp[15];
  StaticJsonBuffer<256> jsonBuffer;
  JsonObject& root = jsonBuffer.parseObject(json_data);
  if (!root.success())
  {
    Serial.println("parseObject() failed");
    return;
  }
  if (root["getname"] == 1) {
    get_name();
    return;
  }
  if (root.containsKey("dev_name") == true)   strcpy(tmp, root["dev_name"]);
  if (!String(tmp).equals(String(dinfo.name_dev))) {
    Serial.println("bad name");
    return;
  }
  if (root.containsKey("ncom") == true)
  {
    do_command(int(root["ncom"]), boolean(root["com"]), boolean(root["lock"]));
  }
  if (root["getapset"] == 1) {
    get_apset();
    return;
  }
  if (root["getstaset"] == 1) {
    get_staset();
    return;
  }
  if (root["rssi"] == 1) send_rssi();
  if (root["rst"] == 1)  ESP.reset();
  if (root.containsKey("ssid_ap") == true)  strcpy(dinfo.ssid_ap, root["ssid_ap"]);
  if (root.containsKey("pass_ap") == true)  strcpy(dinfo.pass_ap, root["pass_ap"]);
  if (root.containsKey("hide_ssid") == true)  dinfo.hide_ssid = boolean(root["hide_ssid"]);
  if (root.containsKey("mode_ap") == true)  dinfo.stmode = not(boolean(root["mode_ap"]));
  if (root.containsKey("ssid_sta") == true)  strcpy(dinfo.ssid_sta, root["ssid_sta"]);
  if (root.containsKey("pass_sta") == true)  strcpy(dinfo.pass_sta, root["pass_sta"]);
  if (root.containsKey("mode_sta") == true)  dinfo.stmode = boolean(root["mode_sta"]);
  if (root.containsKey("font_size") == true)  dinfo.font_size = int(root["font_size"]);
  if (root.containsKey("h_size") == true)  dinfo.h_size = int(root["h_size"]);
  if (root.containsKey("v_size") == true)  dinfo.v_size = int(root["v_size"]);
  if (root.containsKey("newdevname") == true)  strcpy(dinfo.name_dev, root["newdevname"]);
  if (root.containsKey("inet_login") == true)  strcpy(dinfo.mqttlogin, root["inet_login"]);
  if (root.containsKey("inet_pass") == true)  strcpy(dinfo.mqttpass, root["inet_pass"]);
  if (root.containsKey("inet_server") == true)  strcpy(dinfo.mqttserver, root["inet_server"]);
  if (root.containsKey("inet_port") == true)  dinfo.mqttport = int(root["inet_port"]);


  if (root.containsKey("save_info") == true)
  {
    writedinfo();
    send_saveok(int(root["save_info"]));
    return;
  }
  if (root.containsKey("getkey") == true) {
    get_key(int(root["getkey"]));
    return;
  }
  if (root.containsKey("getkey_info") == true) {
    getkey_info();
    return;
  }
  if (root.containsKey("setkey") == true) {
    int ind = root["setkey"];
    strcpy( butnn[ind].txt,  root["name"]);
    butnn[ind].lock = boolean(root["lock"]) ;
    writebuts(ind);
    return;
  }
}
void send_rssi()
{
  char i; 
  long int state_int = 0;
  long rsi = WiFi.RSSI();
  StaticJsonBuffer<256> jsonBuffer;
  JsonObject& root = jsonBuffer.createObject();
  root["rssi"] = rsi;
  for (char i = 30; i >0; i--)
  {
    state_int=state_int << 1;
    if (but_state[i] > 0)
    {
      state_int = state_int | 1;
    }
    else
    {
      state_int = state_int | 0;
    }
  }
  root["st"] = state_int;
  size_t len = root.measureLength() + 1;
  char bufferr[len];
  root.printTo(bufferr, sizeof(bufferr));
  root.printTo(Serial);
  send_udp(bufferr);
}
void do_command(char ind, boolean com, boolean lock)
{
  StaticJsonBuffer<256> jsonBuffer;
  send_to_mk(ind, com);
  if (com == true && lock == true) {
    but_state[ind] = 2;
  }
  if (com == true && lock == false) {
    but_state[ind] = 8;
  }
  send_rssi();
}
void get_key(int ind)
{
  Serial.println("get_key");
  StaticJsonBuffer<256> jsonBuffer;
  JsonObject& root = jsonBuffer.createObject();
  root["name"] = butnn[ind].txt;
  root["lock"] = butnn[ind].lock;
  root["key_id"] = ind;
  size_t len = root.measureLength() + 1;
  char bufferr[len];
  root.printTo(bufferr, sizeof(bufferr));
  root.printTo(Serial);
  send_udp(bufferr);
}
void getkey_info()
{
  Serial.println("get_key_info");
  StaticJsonBuffer<256> jsonBuffer;
  JsonObject& root = jsonBuffer.createObject();
  root["font_size"] = dinfo.font_size;
  root["h_size"] = dinfo.h_size;
  root["v_size"] = dinfo.v_size;
  size_t len = root.measureLength() + 1;
  char bufferr[len];
  root.printTo(bufferr, sizeof(bufferr));
  root.printTo(Serial);
  send_udp(bufferr);
}
void  get_name(void)
{
  Serial.println("get_name");
  StaticJsonBuffer<256> jsonBuffer;
  JsonObject& root = jsonBuffer.createObject();
  root["namedev"] = dinfo.name_dev;
  size_t len = root.measureLength() + 1;
  char bufferr[len];
  root.printTo(bufferr, sizeof(bufferr));
  send_udp(bufferr);
}
void  send_saveok(int sn)
{
  Serial.println("save_ok");
  StaticJsonBuffer<256> jsonBuffer;
  JsonObject& root = jsonBuffer.createObject();
  root["save_ok"] = sn;
  size_t len = root.measureLength() + 1;
  char bufferr[len];
  root.printTo(bufferr, sizeof(bufferr));
  send_udp(bufferr);
}
void  get_apset(void)
{
  Serial.println("get_apset");
  StaticJsonBuffer<256> jsonBuffer;
  JsonObject& root = jsonBuffer.createObject();
  root["ssid_ap"] = dinfo.ssid_ap;
  root["pass_ap"] = dinfo.pass_ap;
  root["hide_ssid"] = dinfo.hide_ssid;
  root["mode_ap"] = not(dinfo.stmode);
  size_t len = root.measureLength() + 1;
  char bufferr[len];
  root.printTo(bufferr, sizeof(bufferr));
  root.printTo(Serial);
  send_udp(bufferr);
}
void  get_staset(void)
{
  char i;
  Serial.println("get_staset");
  StaticJsonBuffer<256> jsonBuffer;
  JsonObject& root = jsonBuffer.createObject();
  root["ssid_sta"] = dinfo.ssid_sta;
  root["pass_sta"] = dinfo.pass_sta;
  root["mode_sta"] = dinfo.stmode;
  size_t len = root.measureLength() + 1;
  char bufferr[len];
  root.printTo(bufferr, sizeof(bufferr));
  send_udp(bufferr);
}
void reset_to_ap(void)
{
  strcpy(dinfo.ssid_ap, "WFKeys");
  strcpy(dinfo.pass_ap, "");
  dinfo.stmode = 0;
  dinfo.hide_ssid = 0;
  writedinfo();
  ESP.reset();
}
void time_tick(void)
{
  char i;
  if (digitalRead(button_pin) == 1)
  {
    ap_but++;
    Serial.println(int(ap_but));
    if (ap_but == 5)
    {
      reset_to_ap();
    }
  }
  else
  {
    ap_but = 0;
  }
  for (i = 1; i < 33; i++)
  {
    if (but_state[i] > 5) {
      but_state[i]-- ;
    }
    if (but_state[i] == 5)  {
      send_to_mk(i, false);
    }
  }

  mqtt_conect_tout--;
}
//////////////////////////////////////////////////////////////////
//Службові функції
//////////////////////////////////////////////////////////////////
void send_to_mk(char ind, boolean state) // Відправка даних до керованого контролера
{
  char i;
  if (int(but_state[ind]) > 5 &&  state) return ;
  if (not(state)) {
    but_state[ind] = 0;
  }
  digitalWrite(sb_pin, HIGH);
  for (i = 0; i < 5; i++)
  {
    digitalWrite(data_pin, (ind & 0b10000));
    ind = ind << 1;
    digitalWrite(clk_pin, HIGH);
    delay(1);
    digitalWrite(clk_pin, LOW);
    delay(1);
    digitalWrite(sb_pin, LOW);
  }
  digitalWrite(data_pin, state);
  digitalWrite(clk_pin, HIGH);
  delay(1);
  digitalWrite(clk_pin, LOW);
  delay(1);
}

//////////////////////////////////////////////////////////////////
//Налаштування і мережа
//////////////////////////////////////////////////////////////////

void setup()
{
  pinMode(button_pin, INPUT);
  pinMode(clk_pin, OUTPUT);
  pinMode(data_pin, OUTPUT);
  pinMode(sb_pin, OUTPUT);
  send_to_mk(0, 0);
  Serial.begin(115200);
  EEPROM.begin(4000);
  readdinfo();
  delay(10);
  for (char i = 1; i < 32; i++)
  {
    delay(10);
    readbuts(i);
  }
  if (dinfo.stmode == 1)
  {
    setup_to_sta();
  }
  else
  {
    setup_to_ap();
  }
  timers.attach(0.5, time_tick);
  Udp.begin(localUdpPort);



}

void loop()
{
  int packetSize = Udp.parsePacket();
  if (packetSize)
  {
    int len = Udp.read(incomingPacket, 255);
    if (len > 0)
    {
      incomingPacket[len] = 0;
    }
    Serial.printf("UDP in: %s\n", incomingPacket);
    proces_json (incomingPacket);
  }
  if ( mqtt_conect_tout == 1 && dinfo.stmode == 1)
  {
    mqtt_conect_tout = 1200;
    Serial.print("MQTT.connected:");
    Serial.println(mqttclient.connected());
    if (mqttclient.connected() == false)  connect_to_mqtt();
  }
  if (mqttclient.connected() == true)  mqttclient.loop();
}
void connect_to_mqtt()
{
  Serial.println("MQTT is connecting......");
  Serial.println(dinfo.mqttserver);
  Serial.println( dinfo.mqttport);
  mqttclient.setServer(dinfo.mqttserver, dinfo.mqttport);

  Serial.println(dinfo.name_dev);
  Serial.println(dinfo.mqttlogin);
  Serial.println(dinfo.mqttpass);
  mqttclient.disconnect();
  if (mqttclient.connect(dinfo.name_dev, dinfo.mqttlogin, dinfo.mqttpass))
  {
    Serial.print("MQTT is connected");
    mqttclient.subscribe("wfkeyin");
  }
}
void callback(char* topic, byte* payload, unsigned int lengt)
{
  Serial.print("Message arrived [");
  Serial.print(topic);
  Serial.print("] ");
  for (int i = 0; i < lengt; i++) {
    Serial.print((char)payload[i]);
  }
  Serial.println();
  memcpy(incomingPacket, payload, lengt);
  proces_json (incomingPacket);

}
void send_udp(char *data)
{
  Serial.println(int(Udp.remoteIP()));
  if (int(Udp.remoteIP()) > 1)
  {
    Udp.beginPacket(Udp.remoteIP(), Udp.remotePort());
    Udp.write(data);
    Udp.endPacket();
  }
  else
  {
    mqttclient.publish("wfkey", data);
  }
}
void setup_to_ap() // Налаштування пристрою в режим  "Точки доступу"
{
  modes = 1; // Режим  "Точки доступу"
  WiFi.mode(WIFI_AP);
  WiFi.softAP(dinfo.ssid_ap, dinfo.pass_ap, 1, dinfo.hide_ssid);
  IPAddress myIP = WiFi.softAPIP();
  Serial.println("AP created");
  Serial.println(myIP);
}
void setup_to_sta() // Налаштування пристрою в режим "Станції"
{
  Serial.print("Connecting");
  WiFi.mode(WIFI_STA);
  WiFi.begin(dinfo.ssid_sta, dinfo.pass_sta); // підключення до WI-FI мережі заданої в налаштуваннях
  uint8_t i = 0;
  while (WiFi.status() != WL_CONNECTED && i++ < 20)
  {
    delay(500);
    if (digitalRead(button_pin) == 1)
    {
      reset_to_ap();
    }
    Serial.print(".");
    if (i == 20)
    {
      Serial.print("Could not connect to");
      Serial.println("");
      delay(500);
      ESP.reset();
    }
  }
  Serial.println("");
  Serial.println("WiFi connected");
  Serial.println("IP address: ");
  Serial.println(WiFi.localIP());
}

void readdinfo() //Читання інформaції з енергонезалежної памяті в оперативну
{
  int i;
  byte eeprom_data_tmp[sizeof(dinfo)];
  for (i = 0; i < sizeof(dinfo); i++)
  {
    eeprom_data_tmp[i] = EEPROM.read(i);
  }
  memcpy(&dinfo, eeprom_data_tmp,  sizeof(dinfo));
  Serial.println(" ");
  Serial.println(" ");
  Serial.println(int(dinfo.firts_run));
  if (dinfo.firts_run != 22)
  {
    Serial.println("first run");
    dinfo.firts_run = 22;
    strcpy(dinfo.name_dev, "WIFIKEYS");
    strcpy(dinfo.ssid_sta, "ssid");
    strcpy(dinfo.pass_sta, "pass");
    strcpy(dinfo.ssid_ap, "WFKeys");
    strcpy(dinfo.pass_ap, "");
    dinfo.stmode = 0;
    dinfo.hide_ssid = 0;
    dinfo.font_size = 12;
    dinfo.h_size = 5;
    dinfo.v_size = 6;
    strcpy(dinfo.mqttserver, "m20.cloudmqtt.com");
    dinfo.mqttport = 13098;
    strcpy(dinfo.mqttlogin, "ofcegqld");
    strcpy(dinfo.mqttpass, "p420I22n4UNE");
    writedinfo();
    Serial.println("buts first run");
    for (i = 1; i < 32; i++)
    {
      yield();
      strcpy(butnn[i].txt, "@");
      butnn[i].lock = false;
      writebuts(i);
    }
  }
}
void writedinfo() //Запис інформaції з оперативної памяті в енергонезалежну
{
  int i;
  byte eeprom_data_tmp[sizeof(dinfo)];
  memcpy(eeprom_data_tmp, &dinfo, sizeof(dinfo));
  for (i = 0; i < sizeof(dinfo); i++)
  {
    EEPROM.write(i, eeprom_data_tmp[i]);
  }
  EEPROM.commit();
}
void readbuts(char but_n) //Читання кнопок з енергонезалежної памяті в оперативну
{
  int i;
  int sinf = sizeof(dinfo);
  int sbt = sizeof(butnn[but_n]);
  byte eeprom_data_tmp[sbt];
  for (i = 0; i < sbt; i++)
  {
    eeprom_data_tmp[i] = EEPROM.read(sinf + (sbt * (but_n - 1)) + i);
  }
  memcpy(&butnn[but_n], eeprom_data_tmp, sbt);
}
void writebuts(char but_n) //Запис кнопок з оперативної памяті в енергонезалежну
{
  Serial.println("buts write");
  int i;
  int sinf = sizeof(dinfo);
  int sbt = sizeof(butnn[but_n]);
  byte eeprom_data_tmp[sbt];
  memcpy(eeprom_data_tmp, &butnn[but_n], sbt);
  for (i = 0; i < sbt; i++)
  {
    EEPROM.write(sinf + (sbt * (but_n - 1)) + i, eeprom_data_tmp[i]);
  }
  EEPROM.commit();
}

