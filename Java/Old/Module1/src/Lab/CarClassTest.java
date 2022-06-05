package Lab;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarClassTest {

    private Car car;                                                    //Car Object

    @Before
    public void setUp() throws Exception {
        car = new Car("CarX", "Regulus L1", 2019);   //Instantiate a Car Object
    }

    @After
    public void tearDown() throws Exception {
        car = null;                                                     //Cleans up Car Object
    }

    @Test
    public void accelerate() {
        car.accelerate();                                               //Initial speed is 0. Adds 5 to speed field
        assertEquals(5, car.getSpeed());                       //Make sure car speed is expected
    }

    @Test
    public void brake() {
        car.accelerate();
        assertEquals(5, car.getSpeed());
        car.brake();                                                    //Lower car speed by 5
        assertEquals(0, car.getSpeed());
    }

    @Test
    public void getDistance() {
        car.accelerate();
        assertEquals(15, car.getDistance(3),0);    //getDistance() is speed * time
    }

    @Test
    public void getTime() {
        car.accelerate();
        assertEquals(20, car.getTime(100),0);   //getTime() is distance / speed
    }
}