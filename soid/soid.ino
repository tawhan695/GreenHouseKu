int a0 ;
int a1 ;
int a2;
int a3;
int a4;

int as0 ;
int as1 ;
int as2;
int as3;
int as4;

int lightinside;
int lightoutside;


void setup() {
   Serial.begin(9600);
   
   

}

void loop() {
 a0=analogRead(A0);
 a0=map(a0,200,1024,0,100);
 as0=map(a0,100,0,0,100);

 a1=analogRead(A1);
 a1=map(a1,200,1024,0,100);
 as1=map(a1,100,0,0,100);

 a2=analogRead(A2);
 a2=map(a2,200,1024,0,100);
 as2=map(a2,100,0,0,100);

 a3=analogRead(A3);
 a3=map(a3,200,1024,0,100);
 as3=map(a3,100,0,0,100);

  a4=analogRead(A4);
 a4=map(a4,100,1024,0,100);
 as4=map(a4,100,0,0,100);
//Serial.print(as0);
//Serial.print(":");
//Serial.print(as1);
//Serial.print(":");
//Serial.print(as2);
//Serial.print(":");
//Serial.print(as3);
//Serial.print(":");
 Serial.print((as0+as1+as2+as3)/4);
 Serial.print(":");
 Serial.println(as4);
 //  Serial.print("  vga :");
//Serial.println(a2);
//delay(500);
}
