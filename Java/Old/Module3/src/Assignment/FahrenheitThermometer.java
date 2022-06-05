package Assignment;

/**
 * FahrenheitThermometer Object.
 * See the CSCI112_A3.pdf document for details.
 *
 * @author Wuheng Yu
 */
public class FahrenheitThermometer extends Thermometer {

    /**
     * Constructor with one argument, the temperature degree(Celsisus or Fahrenheit)
     * Calls the superclass using degrees
     */
    public FahrenheitThermometer(double degrees) {
        super(degrees);
    }

    /**
     * Returns a String, the degrees in Fahrenheit
     */
    public String getTemperature() {
        return getDegrees() + " F";
    }

    /**
     * Sets Fahrenheit degrees
     */
    public void setTemperature(double temperature) {
        setDegrees(temperature);
    }

    /**
     * Converts Fahrenheit to Celsius
     * Returns a String, the rounded degrees Celsius
     */
    public String convert() {
        double celsius;
        celsius = Math.round((getDegrees() - 32) * (5.0/9.0));
        return celsius + " C";
    }
}
