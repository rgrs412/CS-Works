package Assignment;

/**
 * Thermometer Object.
 * See the CSCI112_A3.pdf document for details.
 *
 * @author Wuheng Yu
 */
public abstract class Thermometer implements  Temperature {

    private double degrees;                 //Temperature degree(Celsius or Fahrennheit)

    /**
     * Constructor with one argument, the temperature degree(Celsius or Fahrenheit)
     */
    public Thermometer(double degrees) {
        this.degrees = degrees;
    }

    /**
     * Returns degrees
     */
    public double getDegrees() {
        return degrees;
    }

    /**
     * Sets degrees
     */
    public void setDegrees(double degrees) {
        this.degrees = degrees;
    }

    /**
     * Need to be defined by subclasses of Thermometer
     */
    public abstract String convert();
}
