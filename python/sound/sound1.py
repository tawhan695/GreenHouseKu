import RPi.GPIO as GPIO
import time 
GPIO.setmode(GPIO.BCM)
GPIO.setwarnings(False)
GPIO.setup(19,GPIO.OUT)
GPIO.output(19,True)
print('sound on')
time.sleep(0.1)
GPIO.output(19,False)
print('sound off')
   
