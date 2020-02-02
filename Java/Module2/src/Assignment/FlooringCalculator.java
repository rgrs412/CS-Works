package Assignment;

/**
 * A program that calculates and displays a quote for new flooring.
 *
 * See the CSCI112_A2.pdf document for details.
 *
 * @author Wuheng Yu
 */
import Assignment.House;
import Assignment.FloorType;
import java.util.Scanner;
public class FlooringCalculator {

    /*
     * Main Method. This is where the program begins.
     */
    public static void main(String[] args) {
        String name;                                                            //name of owner
        String phoneNum;                                                        //owner's phone number
        String address;                                                         //owner's street address
        String city;                                                            //owner's city
        String state;                                                           //owner's state
        String zipcode;                                                         //owner's zip code
        int nRoom;                                                              //number of room in owner's house
        double sqft;                                                            //square feet of a room
        int floorChoice;                                                        //floor choices(1 for carpet, 2 for tile, 3 for hardwood)
        int i;                                                                  //loop counter
        FloorType floorType1 = FloorType.CARPET;                                //Instantiate Carpet object
        FloorType floorType2 = FloorType.TILE;                                  //Instantiate Tile object
        FloorType floorType3 = FloorType.HARDWOOD;                              //Instantiate Hardwood object
        Scanner input = new Scanner(System.in);                                 //Instantiate Scanner object

        System.out.print("Enter the customer’s name: ");
        name = input.nextLine();
        System.out.print("Enter the customer’s phone number: ");
        phoneNum = input.nextLine();
        System.out.print("Enter the customer’s street address: ");
        address = input.nextLine();
        System.out.print("Enter the customer’s city: ");
        city = input.nextLine();
        System.out.print("Enter the customer’s state: ");
        state = input.nextLine();
        System.out.print("Enter the customer’s zip code: ");
        zipcode = input.nextLine();
        System.out.print("Enter the number of rooms: ");
        nRoom = Integer.parseInt(input.nextLine());
        System.out.println("");

        House customerHouse = new House(nRoom);                                  //Instantiate a House object with a number of rooms
        customerHouse.setOwnerName(name);                                        //Set name of house owner
        customerHouse.setPhoneNumber(phoneNum);                                  //Set phone number of house owner
        customerHouse.setStreetAddress(address);                                 //Set street address of house owner
        customerHouse.setCity(city);                                             //Set city that house in
        customerHouse.setState(state);                                           //Set state that house is in
        customerHouse.setZipCode(zipcode);                                       //Set zip code of house

        for(i = 0; i < nRoom; i++) {
            System.out.print("Enter the area (in square feet) of room " + (i + 1) + ": ");
            sqft = Double.parseDouble(input.nextLine());
            System.out.print("Select flooring type (1 for Carpet, 2 for Tile, 3 for Hardwood): ");
            floorChoice = Integer.parseInt(input.nextLine());
            System.out.println("");

            while(true) {                                                                                   //Loop adds a room with specified sqft and floor type
                if(floorType1.ordinal() == floorChoice - 1) {
                    customerHouse.addRoom(sqft, floorType1);
                    break;
                }
                else if(floorType2.ordinal() == floorChoice - 1) {
                    customerHouse.addRoom(sqft, floorType2);
                    break;
                }
                else if(floorType3.ordinal() == floorChoice - 1) {
                    customerHouse.addRoom(sqft, floorType3);
                    break;
                }
                else {                                                                                      //If user input of floor choice is invalid, else will keep executing
                    System.out.println("Invalid choice. Enter a valid choice.\n");
                    System.out.print("Select flooring type (1 for Carpet, 2 for Tile, 3 for Hardwood): ");
                    floorChoice = Integer.parseInt(input.nextLine());
                    System.out.println("");
                }
            }
        }
        System.out.println("");
        System.out.println("Price Quote For: \n" + name + "\n" + address + "\n" +                           //Prints out owner's information
                city + ", " + state + " " + zipcode + "\n" + phoneNum + "\n");
        System.out.printf("%-1s%.2f\n", "Total Installation Cost: $", customerHouse.getInstallationCost()); //Prints out total installation cost
        System.out.printf("%-1s%.2f\n", "Total Flooring Cost: $", customerHouse.getFlooringCost());         //Prints out total flooring cost
        System.out.printf("%-1s%.2f\n", "Total Estimated Cost: $", (customerHouse.getInstallationCost() +   //Prints out total cost of installation cost and flooring cost combined
                customerHouse.getFlooringCost()));

    }

}
