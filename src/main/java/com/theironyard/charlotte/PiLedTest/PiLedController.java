package com.theironyard.charlotte.PiLedTest;

import com.pi4j.io.gpio.*;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

/**
 * Created by Jake on 5/11/17.
 */

@Controller
public class PiLedController {
    public static final GpioController gpio = GpioFactory.getInstance();
    public static GpioPinDigitalOutput myLed = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04,   // PIN NUMBER
            "My LED",           // PIN FRIENDLY NAME (optional)
            PinState.LOW);      // PIN STARTUP STATE (optional)
    // explicitly set a state on the pin object
    public static Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Led [on/off]");
        String onOff = inputScanner.nextLine();
        if (onOff.equalsIgnoreCase("on")) {
            myLed.high();
        } else if (onOff.equalsIgnoreCase("off")) {
            myLed.toggle();
        } else {
            System.err.println("Invalid entry");


        }

    }
}
