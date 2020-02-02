package Assignment;

/**
 * House Object.
 * See the CSCI112_A2.pdf document for details.
 *
 * @author Wuheng Yu
 */
public class House {

    private String ownerName;                                                            //Name of owner
    private String phoneNumber;                                                          //Owner phone number
    private String streetAddress;                                                        //Owner street address
    private String city;                                                                 //Owner's home city
    private String state;                                                                //Owner's home state
    private String zipCode;                                                              //Owner's zip code
    private Room[] rooms;                                                                //Number of rooms in house
    private int roomIndex;                                                               //Index of room objects in array

    /**
     *Constructor with one argument, the number of room in a house object.
     *Fields are given default values.
     */
    public House(int numRooms) {
        ownerName = "";
        phoneNumber = "";
        streetAddress = "";
        city = "";
        state = "";
        zipCode = "";
        rooms = new Room[numRooms];                                                       //Instantiates a specified array of rooms
        roomIndex = 0;
    }

    /**
     * Returns owner's name
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * Returns owner's phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Returns owner's street address
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * Returns owner's city
     */
    public String getCity() {
        return city;
    }

    /**
     * Returns owner's state
     */
    public String getState() {
        return state;
    }

    /**
     * Returns owner's zip code
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Set owner's name
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    /**
     * Set owner's name
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Set owner's street address
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * Set owner's city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Set owner's state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Set owner's zip code
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Add or instantiates a room to an array index and increment roomIndex
     */
    public void addRoom(double sqft, FloorType fType) {
        rooms[roomIndex] = new Room(sqft, fType);
        roomIndex++;
    }

    /**
     * Calculates and return total Installation Cost
     * Installation cost is $10 per square feet
     */
    public double getInstallationCost() {
        double totalInstallationCost = 0;                                        //Total cost of installation
        double totalSqft = 0;
        for(roomIndex = 0; roomIndex < rooms.length; roomIndex++) {
            totalSqft = totalSqft + rooms[roomIndex].getArea();
        }

        totalInstallationCost = totalSqft * 10.00;
        return totalInstallationCost;
    }

    /**
     * Calculates and return total Flooring Cost
     * Carpet cost per square feet is $7
     * Tile is $5
     * Hardwood is $6
     */
    public double getFlooringCost() {
        double totalFlooringCost;                                                 //Total flooring cost
        double totalCarpetCost = 0;                                               //Total carpet flooring cost
        double totalTileCost = 0;                                                 //Total tile flooring cost
        double totalHardwoodCost = 0;                                             //Total hardwood flooring cost

        for(roomIndex = 0; roomIndex < rooms.length; roomIndex++) {
            if(rooms[roomIndex].getFloorType().equals(FloorType.CARPET)) {
                totalCarpetCost = totalCarpetCost + (rooms[roomIndex].getArea() * 7.00);
            }
            else if(rooms[roomIndex].getFloorType().equals(FloorType.TILE)) {
                totalTileCost = totalTileCost + (rooms[roomIndex].getArea() * 5.00);
            }
            else if(rooms[roomIndex].getFloorType().equals(FloorType.HARDWOOD)) {
                totalHardwoodCost = totalHardwoodCost + (rooms[roomIndex].getArea() * 6.00);
            }
        }
        totalFlooringCost = totalCarpetCost + totalTileCost + totalHardwoodCost;
        return totalFlooringCost;
    }

    /**
     * Room Object.
     * See the CSCI112_A2.pdf document for details.
     */
    private class Room {
        private double area;                                                        //area in square feet of a room
        private FloorType floorType;                                                //type of flooring carpet, tile, or hardwood

        /**
         * Constructor with two argument, area of room and type of flooring
         */
        public Room(double areaIn, FloorType floorType) {
            area = areaIn;
            this.floorType = floorType;
        }

        /**
         * Set area of room
         */
        public double getArea() {
            return area;
        }

        /**
         * Set room floor type
         */
        public FloorType getFloorType() {
            return floorType;
        }
    }

}
