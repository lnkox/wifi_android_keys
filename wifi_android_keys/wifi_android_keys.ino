
#include <ESP8266WiFi.h>
#include <WiFiClient.h> 
#include <EEPROM.h>
#include <ArduinoJson.h>
#include <Ticker.h>

const char *ssid = "keys32_1";
const char *password = "";

const byte button_pin = D2; // пін для апаратної кнопки зміни режиму
const byte clk_pin=D1;
const byte data_pin=D5;
const byte sb_pin=D6;

char modes=0; //тип зєднання з пристроєм
char data_type=0;
char command=0;
struct butn_st
{
  char txt[60];
  boolean lock;
  char butname[6];
  boolean chk;
  
};

struct eeprom_data_t {
  char firts_run;
  char eessid[20];
  char eepass[20];
  char devip[4];
  boolean stmode;
  char fnts;
  char v_size;
  char h_size;
  butn_st butnn[33];
  
  
} eeprom_data;
char tmpjson[1000];
char num_inf;
char but_state[33];
char send_rssi_tmr=0;
char ap_but;
boolean connect_show=true;
WiFiServer server(80);
WiFiClient serverClient;
Ticker timers;
void setup_to_ap() // Налаштування пристрою в режим  "Точки доступу"
{
  modes=1;  // Режим  "Точки доступу"
  IPAddress ip(eeprom_data.devip[0],eeprom_data.devip[1],eeprom_data.devip[2],eeprom_data.devip[3]); 
  IPAddress gateway(eeprom_data.devip[0],eeprom_data.devip[1],eeprom_data.devip[2],eeprom_data.devip[3]); 
  IPAddress subnet(255, 255, 255, 0); 
  WiFi.softAPConfig(ip, gateway, subnet);
  WiFi.config(ip, gateway, subnet);
  WiFi.mode(WIFI_AP);
  WiFi.softAP(ssid, password);
  
  IPAddress myIP = WiFi.softAPIP();
  Serial.println("AP created");
  Serial.println(myIP);
}
void setup_to_sta() // Налаштування пристрою в режим "Станції"
{
  modes=0;  // режим станції
  IPAddress ip(eeprom_data.devip[0],eeprom_data.devip[1],eeprom_data.devip[2],eeprom_data.devip[3]); 
  IPAddress gateway(eeprom_data.devip[0],eeprom_data.devip[1],eeprom_data.devip[2],eeprom_data.devip[3]); 
  IPAddress subnet(255, 255, 255, 0); 
  WiFi.config(ip, gateway, subnet);
  Serial.println();
  Serial.println();
  Serial.print("Connecting to ");
  Serial.println(eeprom_data.eessid);
  WiFi.mode(WIFI_STA);
  WiFi.begin(eeprom_data.eessid,eeprom_data.eepass); // підключення до WI-FI мережі заданої в налаштуваннях
  uint8_t i = 0;
  while (WiFi.status() != WL_CONNECTED && i++ < 20)
  {
    delay(500);
    Serial.print(".");
     if (ap_but==10) {return;}
    if(i == 20)
    {
      Serial.print("Could not connect to"); Serial.println(eeprom_data.eessid);
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
void proces_tcp_data(char data)
{
  Serial.print(data);
  if (data=='{') {memset (&tmpjson,0,200); num_inf=0; tmpjson[num_inf]=data; return;}
  if (data=='}') {tmpjson[num_inf+1]=data;proces_json(tmpjson); return;}
  num_inf++;
  tmpjson[num_inf]=data;
}
void proces_json(char *json_data)
{
  char tmindbut;
  StaticJsonBuffer<256> jsonBuffer;
  JsonObject& root = jsonBuffer.parseObject(json_data);
  if (!root.success()) {
    Serial.println("parseObject() failed");
    return;
   }
   if (root["info"]==1) get_info();
   if (root["rssi"]==1) send_rssi();
   if (root["rst"]==1)  ESP.reset();
   if (root.containsKey("ssid")==true)  strcpy(eeprom_data.eessid, root["ssid"]);
   if (root.containsKey("pass")==true) strcpy(eeprom_data.eepass, root["pass"]); 
   if (root.containsKey("ip0")==true) eeprom_data.devip[0]=int(root["ip0"]); 
   if (root.containsKey("ip1")==true) eeprom_data.devip[1]=int(root["ip1"]);
   if (root.containsKey("ip2")==true) eeprom_data.devip[2]=int(root["ip2"]); 
   if (root.containsKey("ip3")==true) eeprom_data.devip[3]=int(root["ip3"]); 
   if (root.containsKey("fnts")==true) eeprom_data.fnts=int(root["fnts"]); 
   if (root.containsKey("stmode")==true) eeprom_data.stmode=boolean(root["stmode"]); 
   if (root.containsKey("v_size")==true) eeprom_data.v_size=int(root["v_size"]);  
   if (root.containsKey("h_size")==true) eeprom_data.h_size=int(root["h_size"]); 
   if (root.containsKey("indbut")==true)
   {
     tmindbut=int(root["indbut"]);
     strcpy(eeprom_data.butnn[tmindbut].txt, root["txt"]);
     eeprom_data.butnn[tmindbut].chk=boolean(root["chk"]); 
     if (tmindbut==32)  writeSet();
   }
   if (root.containsKey("ncom")==true)
   {
      do_command(int(root["ncom"]),boolean(root["com"]),boolean(root["lock"]));
   }
}
void do_command(char ind,boolean com,boolean lock)
{
  StaticJsonBuffer<256> jsonBuffer;
  send_to_mk(ind,com);
  if (com==true && lock==true) { but_state[ind]=2;}
  if (com==true && lock==false) { but_state[ind]=8;}
  JsonObject& root = jsonBuffer.createObject();
  root["rcom"] = com;
  root["rind"] = ind;
  size_t len=root.measureLength()+1;
  uint8_t sbuf[len];
  char bufferr[len];
  root.printTo(bufferr, sizeof(bufferr));
  memcpy(sbuf,&bufferr,len);  
  serverClient.write(sbuf,len);
}
void send_to_mk(char ind,boolean state)
{
  char i;
  if (int(but_state[ind])>5 &&  state) return ;
  if (not(state)) {but_state[ind]=0;}
  digitalWrite(sb_pin, HIGH);   
  for (i=0; i<5; i++)
  { 
    digitalWrite(data_pin, (ind & 0b10000)); 
    ind=ind<<1;                               
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
void get_info(void)
{
  char i;
  Serial.println("Info");
  StaticJsonBuffer<256> jsonBuffer;
  JsonObject& root = jsonBuffer.createObject();
  root["ssid"] = eeprom_data.eessid;
  root["pass"] = eeprom_data.eepass;
  root["ip0"] = eeprom_data.devip[0];
  root["ip1"] = eeprom_data.devip[1];
  root["ip2"] = eeprom_data.devip[2];
  root["ip3"] = eeprom_data.devip[3];
  root["fnts"] = eeprom_data.fnts;
  root["stmode"] = eeprom_data.stmode;
  root["v_size"] = eeprom_data.v_size;
  root["h_size"] = eeprom_data.h_size;  
  size_t len=root.measureLength()+1;
  uint8_t sbuf[len];
  char bufferr[len];
  root.printTo(Serial);
  root.printTo(bufferr, sizeof(bufferr));
  memcpy(sbuf,&bufferr,len);  
  serverClient.write(sbuf,len);
  for (i =1; i <33; i=i+3)
  {
    delay(10);
    get_btn(i);
  }
}
void get_btn(char indb)
{
  StaticJsonBuffer<256> jsonBuffer;
  JsonObject& root = jsonBuffer.createObject();
  JsonArray& but_data = root.createNestedArray(eeprom_data.butnn[indb].butname);
  but_data.add(eeprom_data.butnn[indb].txt); 
  but_data.add(eeprom_data.butnn[indb].chk);
  but_data.add(but_state[indb]);
  indb++;
  JsonArray& but_data1 = root.createNestedArray(eeprom_data.butnn[indb].butname);
  but_data1.add(eeprom_data.butnn[indb].txt); 
  but_data1.add(eeprom_data.butnn[indb].chk);
  but_data1.add(but_state[indb]);
  indb++;
  JsonArray& but_data2 = root.createNestedArray(eeprom_data.butnn[indb].butname);
  but_data2.add(eeprom_data.butnn[indb].txt); 
  but_data2.add(eeprom_data.butnn[indb].chk);
  but_data2.add(but_state[indb]);
  size_t len=root.measureLength()+1;
  uint8_t sbuf[len];
  char bufferr[len];
  root.printTo(Serial);
  root.printTo(bufferr, sizeof(bufferr));
  memcpy(sbuf,&bufferr,len);  
  serverClient.write(sbuf,len);
}

void setup()
{
  pinMode(button_pin, INPUT);
  pinMode(clk_pin, OUTPUT);
  pinMode(data_pin, OUTPUT);
  pinMode(sb_pin, OUTPUT);
   send_to_mk(0,0);
  timers.attach(0.5, time_tick);
  
  Serial.begin(115200);
  readSet();
  delay(1000);
  if (eeprom_data.stmode==1) {setup_to_sta();} else {setup_to_ap();}
 //setup_to_ap();
  server.begin();
  server.setNoDelay(true);
  Serial.print(WiFi.softAPIP());
  Serial.println(WiFi.localIP()); 
  Serial.println("port 80 to connect");
}
void time_tick(void)
{
  char i;
  if (digitalRead(button_pin)==1)
  {
      ap_but++;
       Serial.println(int(ap_but));
      if (ap_but==10)
      {
        WiFi.disconnect(true);
        setup_to_ap();
      }
  }
  else
  {
    ap_but=0;
  }
  for (i =1; i <33; i++)
  {
    if (but_state[i]>5) {but_state[i]-- ;}
    if (but_state[i]==5)  {send_to_mk(i,false);}
  }
} 
void send_rssi()
{
char i;
 long rsi = WiFi.RSSI();
  StaticJsonBuffer<256> jsonBuffer;
  JsonObject& root = jsonBuffer.createObject();
  connect_show=not(connect_show);
  root["connect_show"] =connect_show;
  root["rssi"] =rsi;
  size_t len=root.measureLength()+1;
  uint8_t sbuf[len];
  char bufferr[len];
  root.printTo(bufferr, sizeof(bufferr));
  memcpy(sbuf,&bufferr,len);  
  serverClient.write(sbuf,len);
}
void loop()
{
   if (server.hasClient())
   {
     if (!serverClient || !serverClient.connected())
     {
        if(serverClient) serverClient.stop();
        serverClient = server.available();
        Serial.println("New client");
     }
      WiFiClient serverCl = server.available();
      serverCl.stop();
    }
    if (serverClient && serverClient.connected())
    {
      if(serverClient.available())
      {
        while(serverClient.available())
        {
          proces_tcp_data(serverClient.read());
        }
      }
    }
}
void readSet() //Читання налаштувань з енергонезалежної памяті в оперативну
{
  int i;
  byte eeprom_data_tmp[sizeof(eeprom_data)];
  char jn[6]="but00";
  EEPROM.begin(sizeof(eeprom_data));
  for (i =0; i <sizeof(eeprom_data); i++)
  {
    eeprom_data_tmp[i] = EEPROM.read(i);
  }
 memcpy(&eeprom_data, eeprom_data_tmp,  sizeof(eeprom_data));
 EEPROM.end();
 if (eeprom_data.firts_run!=22) 
 {
   Serial.println("first run");
   Serial.println(int(eeprom_data.firts_run));
   eeprom_data.firts_run=22;
    eeprom_data.devip[0]=192; eeprom_data.devip[1]=168; eeprom_data.devip[2]=0; eeprom_data.devip[3]=22;
   eeprom_data.fnts=10;
   eeprom_data.stmode=false;
   eeprom_data.v_size=8;
   eeprom_data.h_size=4;
   Serial.println("p1");
   strcpy(eeprom_data.eessid,"ssid");
   strcpy(eeprom_data.eepass,"pass");
   Serial.println("p2");
   for (i =1; i <33; i++)
  {
    yield();
   strcpy(eeprom_data.butnn[i].txt,"Button");
   eeprom_data.butnn[i].chk=false;
   jn[3]=char(i/10+48);
   jn[4]=char(i%10+48);
   strcpy(eeprom_data.butnn[i].butname,jn);
  }
  Serial.println("p3");

 }
 String("Bubuka").toCharArray(eeprom_data.eessid, sizeof(eeprom_data.eessid));
 String("22011993").toCharArray(eeprom_data.eepass, sizeof(eeprom_data.eepass));

}

void writeSet() //Запис налаштувань з оперативної памяті в енергонезалежну
{
  int i;
   Serial.println("sizeof(eeprom_data)");
   Serial.println(sizeof(eeprom_data));
  byte eeprom_data_tmp[sizeof(eeprom_data)];
  EEPROM.begin(sizeof(eeprom_data));
  Serial.println("beg");
  memcpy(eeprom_data_tmp, &eeprom_data, sizeof(eeprom_data));
  Serial.println("memc");
  yield();
  for (i = 0; i < sizeof(eeprom_data); i++)
  {
    EEPROM.write(i, eeprom_data_tmp[i]);
  }
    Serial.println("bef end");
  EEPROM.end();
}

