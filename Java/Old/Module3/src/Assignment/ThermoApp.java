package Assignment;

/**
 * Thermometer Application.
 * See the CSCI112_A3.pdf document for details.
 *
 * @author Wuheng Yu
 */
import java.util.Scanner;
public class ThermoApp {

    /**
     * Main Method. This is where the program begins.
     */
    public static void main(String[] args) {
        String tempType;                                                                    //temperature type(Celsius or Fahrenheit)
        Double degrees;                                                                     //degrees(either Celsius or Fahrenheit)
        Scanner input = new Scanner(System.in);                                             //Instantiate a Scanner object
        Thermometer therm = null;                                                           //Declares Thermometer object

        System.out.print("Choose Fahrenheit (F) or Celsius (C): ");
        tempType = input.nextLine();

        if(tempType.equalsIgnoreCase("f")) {                                   //Runs if user enters F or f
            System.out.print("Enter the degrees: ");
            degrees = Double.parseDouble(input.nextLine());
            therm = new FahrenheitThermometer(degrees);                                     //Instantiates a FahrenheitThermometer object
            System.out.println("");
        }

        if(tempType.equalsIgnoreCase("c")) {                                   //Runs if user enters C or c
            System.out.print("Enter the degrees: ");
            degrees = Double.parseDouble(input.nextLine());
            therm = new CelsiusThermometer(degrees);                                        //Instantiates a CelsiusThermometer object
            System.out.println("");
        }

        displayTemperature(therm);                                                          //Calls the displayTemperature method
        displayConversion(therm);                                                           //Calls the displayConversion method
    }

    /**
     * Displays the temperature
     * Aside from uncommenting the one line, DO NOT MODIFY
     * If the line doesn't compile, something is wrong with how you programmed the Temperature class
     */
    public static void displayTemperature(Temperature t) {
        System.out.println("The temperature is " + t.getTemperature());
    }

    /**
     * Displays the converted temperature
     * Aside from uncommenting the one line, DO NOT MODIFY
     * If the line doesn't compile, something is wrong with how you programmed the Thermometer class
     */
    public static void displayConversion(Thermometer t) {
        System.out.println("The temperature converted is " + t.convert());
    }

}
