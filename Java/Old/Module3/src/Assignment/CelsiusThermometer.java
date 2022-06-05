package Assignment;

/**
 * CelsiusThermometer Object.
 * See the CSCI112_A3.pdf document for details.
 *
 * @author Wuheng Yu
 */
public class CelsiusThermometer extends Thermometer {

    /**
     * Constructor with one argument, the temperature degree(Celsisus or Fahrenheit)
     * Calls the superclass using degrees
     */
    public CelsiusThermometer(double degrees) {
        super(degrees);
    }

    /**
     * Returns a String, the degrees in Celsius
     */
    public String getTemperature() {
        return getDegrees() + " C";
    }

    /**
     * Sets Celsius degrees
     */
    public void setTemperature(double temperature) {
        setDegrees(temperature);
    }

    /**
     * Converts Celsius to Fahrenheit
     * Returns a String, the rounded degrees Fahrenheit
     */
    public String convert() {
        double fahrenheit;
        fahrenheit = Math.round((getDegrees() * (9.0/5.0)) + 32);
        return fahrenheit + " F";
    }
}
