package Lab;

/**
 * CargoShip Object.
 * 
 * This should be a subclass of the Ship class.
 * 
 * It should have one field, an int, named capacity. (The maximum tonnage of the Cargo Ship)
 * 
 * It should contain a constructor. It should accept arguments for the capacity field
 * and arguments for the superclass's constructor.
 * 
 * It should contain accessor and mutator methods for the capacity field.
 *
 * The capacity field should only allow values between 0 and 1000.
 * 
 * Its toString method should return a String that contains:
 * The value of its capacity field.
 * The values of its superclass's fields (name and yearBuilt)
 */
public class CargoShip extends Ship {

    private int capacity;

    public CargoShip(int capacity, String nameIn, String yearBuiltIn) {
        super(nameIn, yearBuiltIn);
        if ((capacity >= 0) || (capacity <= 1000)) {
            this.capacity = capacity;
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if ((capacity >= 0) || (capacity <= 1000)) {
            this.capacity = capacity;
        }
    }

    public String toString() {
        return "Capacity(ton): " + getCapacity() + "\nShip Name: " + getName() + "\nYear Built: " + getYearBuilt();
    }
}
