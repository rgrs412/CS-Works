package Lab;

/**
 * Car Object.
 * 
 * Create four private fields: make (String), model (String), year (int), and speed (int).
 * Do not give the fields default/starting values.
 * 
 * Create a constructor that accepts three arguments (for the make, model, and year fields).
 * The constructor should set the speed field to 0.
 * 
 * Create accessors for each of the four fields.
 * 
 * Create mutators for only the make, model, and year fields.
 * 
 * Create a public void method called accelerate that adds 5 to the speed field.
 * 
 * Create a public void method called brake that subtracts 5 from the speed field.
 * Ensure the car's speed does not go below zero.
 *
 * Create a public method called getDistance that returns a double. The function should accept
 * an argument (int) called time. When called the method will calculate and return the distance
 * the car will travel at its current speed.
 * D = S * T
 *
 * Create a public method called getTime that returns a double. The function should accept
 * an argument (int) called distance. When called the method will calculate and return the time
 * it will take the car to travel that distance at its current speed.
 * T = D / S
 * 
 */
public class Car {

    private String make; //Car Brand
    private String model;//Car Model
    private int year;    //Car created year
    private int speed;   //Car speed
    
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.speed = 0;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getSpeed() {
        return speed;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void accelerate() {
        speed = speed + 5;
    }

    public void brake() {
        speed = speed - 5;
        if(speed < 0) {
            speed = 0;
        }
    }

    public double getDistance(int time) {
        return speed * time;
    }

    public double getTime(int distance) {
        return distance / speed;
    }
}//end Car class
