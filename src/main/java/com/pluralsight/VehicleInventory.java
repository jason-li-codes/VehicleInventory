package com.pluralsight;

import java.util.*;

public class VehicleInventory {

    // creates public static integer variable of the currentInventory
    public static int currentInventory = 0;

    public static void main(String[] args) {

        // creates carshop as a Vehicle array, with 20 slots
        Vehicle[] carshop = new Vehicle[20];
        // adds 6 Vehicles already established
        carshop[0] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500);
        carshop[1] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        carshop[2] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700);
        carshop[3] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500);
        carshop[4] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500);
        carshop[5] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000);

        // establishes currentInventory as 6
        currentInventory = 6;

        // imports and names scanner
        Scanner input = new Scanner(System.in);

        // creates a boolean isRunning to allow user to run methods multiple times
        boolean isRunning = true;

        // while loop will keep running as long as the user keeps isRunning true by choosing options
        while (isRunning) {

            // prints out all user options
            System.out.println("""
                    What would you like to do?
                    (1) List all vehicles
                    (2) Search by make/model
                    (3) Search by price range
                    (4) Search by color
                    (5) Add a vehicle
                    (6) Quit
                    """);

            // takes user input as int option, with an additional line to eat the buffer
            int option = input.nextInt();
            input.nextLine();

            // switch statement to choose through all the options, which lead to different methods
            // all cases will lead to other methods
            switch (option) {
                case 1:
                    listAllVehicles(carshop);
                    break;
                case 2:
                    searchByMakemodel(carshop, input);
                    break;
                case 3:
                    searchByPrice(carshop, input);
                    break;
                case 4:
                    searchByColor(carshop, input);
                    break;
                case 5:
                    addVehicle(carshop, input);
                    break;
                // case 6 will make isRunning false, ending the program by exiting the while loop
                case 6:
                    isRunning = false;
                    System.out.println("ENDING PROGRAM...");
                    break;
            }

        }

    }

    // takes a Vehicle object and prints out all its info, to be called in other methods
    public static void printVehicleInfo(Vehicle car) {

        // prints out all the Vehicle class attributes
        System.out.printf("%s %s - ID: %d, odometer reading: %d, price: $%.2f\n",
                car.getColor(), car.getMakeModel(), car.getVehicleID(),
                car.getOdometerReading(), car.getPrice());

    }

    // lists all Vehicles
    public static void listAllVehicles(Vehicle[] carshop) {

        // calls printVehicleInfo method only for cars in the currentInventory
        for (int i = 0; i < currentInventory; i++) {
            Vehicle car = carshop[i];
            System.out.printf("Vehicle #%d. ", i + 1);
            printVehicleInfo(car);
        }
    }

    // searches by makeModel name
    public static void searchByMakemodel(Vehicle[] carshop, Scanner input) {

        // prompts user for makeModel they're looking for
        System.out.println("What make/model are you looking for?");
        String searchMakemodel = input.nextLine();

        // uses for loop to check every car in currentInventory
        System.out.println("Here are cars matching that make/model:");
        for (int i = 0; i < currentInventory; i++) {
            Vehicle car = carshop[i];
            // checks each car's makeModel to the entered makeModel, lowercased
            if (car.getMakeModel().toLowerCase().contains(searchMakemodel.toLowerCase())) {
                printVehicleInfo(car);
            }
        }

    }

    // searches by price
    public static void searchByPrice(Vehicle[] carshop, Scanner input) {

        // asks user for minimum and maximum spend
        System.out.println("What is the minimum you want to spend?");
        int minPrice = input.nextInt();
        System.out.println("What is the maximum you are willing to spend?");
        int maxPrice = input.nextInt();

        // uses for loop to check each car's price
        System.out.println("Here are cars that match your budget:");
        for (int i = 0; i < currentInventory; i++) {
            Vehicle car = carshop[i];
            // uses if statement to check that car's price is between the min and max budget
            if (minPrice <= car.getPrice() && car.getPrice() <= maxPrice) {
                printVehicleInfo(car);
            }
        }

    }

    // searches by color
    public static void searchByColor(Vehicle[] carshop, Scanner input) {

        // asks user for color they're looking for
        System.out.println("What color are you looking for?");
        String searchColor = input.nextLine();

        // uses for loop to check each car's color
        System.out.println("Here are cars matching that color:");
        for (int i = 0; i < currentInventory; i++) {
            Vehicle car = carshop[i];
            // checks each car's color to the entered color, lowercased
            if (car.getColor().toLowerCase().contains(searchColor.toLowerCase())) {
                printVehicleInfo(car);
            }
        }

    }

    // adds new Vehicle object to carshop
    public static void addVehicle(Vehicle[] carshop, Scanner input) {

        // creates Vehicle with null values
        Vehicle car = new Vehicle();

        // prompts user for info of Vehicle
        System.out.println("Let's get the vehicle information first.");
        System.out.println("What is the Vehicle ID?");
        car.setVehicleID(input.nextLong());
        // eats buffer
        input.nextLine();
        System.out.println("What is the make/model?");
        car.setMakeModel(input.nextLine());
        System.out.println("What is the color?");
        car.setColor(input.nextLine());
        System.out.println("What is the odometer reading?");
        car.setOdometerReading(input.nextInt());
        System.out.println("What will be the car's price?");
        car.setPrice(input.nextFloat());
        // eats buffer
        input.nextLine();

        // adds Vehicle to carshop at the next available index, and updates currentInventory
        System.out.println("This car has been added to the inventory.");
        carshop[currentInventory] = car;
        currentInventory++;

    }

}
