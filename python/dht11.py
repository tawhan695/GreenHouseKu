#DHT11
#Modul
#by Tawhan Studio

import Adafruit_DHT

#set sensor
sensor=Adafruit_DHT.DHT11


def setDHT(gpio):
    humidity, temperature = Adafruit_DHT.read_retry(sensor, gpio)
    if humidity is not None and temperature is not None:
       print('Temp={0:0.1f}*C  Humidity={1:0.1f}%'.format(temperature, humidity))
       return('{0:0} {1:0}'.format(temperature, humidity))
        
    else:
       print('Failed to get reading. Try again!')
       return('Failed to get reading. Try again!')
print(setDHT(17))   
