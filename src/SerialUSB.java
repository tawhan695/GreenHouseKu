
import com.pi4j.wiringpi.Serial;
import java.util.logging.Level;
import java.util.logging.Logger;

class SerialUSB{
    

private static int demo1Command = 1;
    public static void main(String[] args) {
                    
             Demo1();
        
    }
    public static String Demo1() {
        String soil="";

	int serialPort = Serial.serialOpen("/dev/ttyACM0", 9600);

	if (serialPort == -1) {
		System.out.println("Serial Port failed/not connected");
		return "Serial Port failed/not connected";
	} else {
		System.out.println("Serial Port Initialized");
	}

	Serial.serialPuts(serialPort, (demo1Command + ""));

	          
            while (Serial.serialDataAvail(serialPort) > 0) {
		char inChar = (char) Serial.serialGetchar(serialPort);
		String s=Character.toString(inChar);
                soil.concat(s);
                
                
	}   
            System.out.print(soil);
            System.out.println("####");
            //    Thread.sleep(2000);
        

	

//8888888888888
return "Demo mode 1";
   // return null;
}
}
