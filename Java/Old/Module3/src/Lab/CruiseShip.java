package Lab;

/**
 * CruiseShip Object.
 * 
 * This should be a subclass of the Ship class.
 * 
 * It should have one field, an int, named passengers. (The number of people on the Cruise Ship)
 * 
 * It should contain a constructor. It should accept arguments for the passengers field
 * and arguments for the superclass's constructor.
 * 
 * It should contain accessor and mutator methods for the passengers field.
 *
 * The passengers field should only allow values between 0 and 5000.
 * 
 * Its toString method should return a String that contains:
 * The value of its passengers field.
 * The values of its superclass's fields (the ship's name and the year it was built)
 */
public class CruiseShip extends Ship {
    
    private int passengers;

    public CruiseShip(int passengers, String nameIn, String yearBuiltIn) {
        super(nameIn, yearBuiltIn);
        if ((passengers >= 0) || (passengers <= 5000)) {
            this.passengers = passengers;
        }
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        if ((passengers >= 0) || (passengers <= 5000)) {
            this.passengers = passengers;
        }
    }

    public String toString() {
        return "Passengers: " + getPassengers() + "\nShip Name: " + getName() + "\nYear Built: " + getYearBuilt();
    }
}
