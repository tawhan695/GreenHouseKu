/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author TanongsakBOONMA
 */
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DHT11Demo {
    public static void main(String[] args) throws InterruptedException {
        DHT11 dht11 = new DHT11(15); // use GPIO pin 15

        while (true) {
            DHT11Result result = dht11.read();

            if (result.isValid()) {
                System.out.println("Last valid input: " + new Date());
                System.out.printf("Temperature: %.1f C\n" , result.getTemperature());
                System.out.printf("Humidity:    %.1f %%\n", result.getHumidity());
            }

            TimeUnit.SECONDS.sleep(2);
        }
    }
}