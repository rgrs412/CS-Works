package Lab;

/**
 * Demonstrates the usage of the Car Object.
 * (Complete the Car class first)
 */
import Lab.Car;
public class CarTest {
    
    public static void main(String[] args) {
        //Create an instance of the Car object:
        //- Name the variable testCar
        //- You can choose the make, model, and year

        //"Accelerate" the car to 65 (miles per hour)

        //Print the car's current speed to verify it is travelling at that speed.

        //Use the car's getDistance method to get the distance it will travel in 3 (hours)
        //Print the distance you calculated.

        //Use the car's getTime method to get the time it will take to travel 500 (miles)
        //Print the time you calculated.

        //"Brake" the car to 0 (miles per hour)

        //Print the car's current speed to verify it is travelling at that speed.

        int i;//Loop counter

        Car testCar = new Car("CarX","Regulus L1", 2019);//Creates a Car object

        for(i = 0; i < 13; i++) {
            testCar.accelerate();//Accelerate car speed to 65
        }

        System.out.println("Current Speed(mph): " + testCar.getSpeed());        //Prints current car speed
        System.out.println("Distance(miles): " + testCar.getDistance(3)); //Prints distance traveled in 3 hours
        System.out.println("Time(hours): " + testCar.getTime(500));    //Prints time it takes to travel 500 miles at current speed

        while(true) {
            if(testCar.getSpeed() != 0) {
                testCar.brake();//Car speed is reduced by 5 until it's 0
            }
            else {
                break;//Break out of loop once car speed is 0
            }
        }//end while(True)

        System.out.print("Current Speed(mph): " + testCar.getSpeed());//Prints current car speed
    }//end main()
    
}//end class CarTest
