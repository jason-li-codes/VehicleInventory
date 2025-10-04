package com.pluralsight;

import java.util.*;

public class VehicleInventory {

    public static int currentInventory = 0;

    public static void main(String[] args) {

        Vehicle[] carshop = new Vehicle[20];
        carshop[0] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500);
        carshop[1] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        carshop[2] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700);
        carshop[3] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500);
        carshop[4] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500);
        carshop[5] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000);

        currentInventory = 6;

        Scanner input = new Scanner(System.in);

        boolean isRunning = true;
        while (isRunning) {

            System.out.println("""
                            What would you like to do?
                            (1) List all vehicles
                            (2) Search by make/model
                            (3) Search by price range
                            (4) Search by color
                            (5) Add a vehicle
                            (6) Quit
                            """);
            int option = input.nextInt();
            input.nextLine();

            switch(option) {
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
                case 6:
                    isRunning = false;
                    System.out.println("ENDING PROGRAM...");
                    break;
            }

        }

    }

    public static void printVehicleInfo(Vehicle car) {

        System.out.printf("%s %s - ID: %d, odometer reading: %d, price: $%.2f\n",
                car.getColor(), car.getMakeModel(), car.getVehicleID(),
                car.getOdometerReading(), car.getPrice());

    }

    public static void listAllVehicles(Vehicle[] carshop) {

        for (int i = 0; i < currentInventory; i++) {
            Vehicle car = carshop[i];
            System.out.printf("Vehicle #%d. ", i + 1);
            printVehicleInfo(car);
        }
    }

    public static void searchByMakemodel(Vehicle[] carshop, Scanner input) {

        System.out.println("What make/model are you looking for?");
        String searchMakemodel = input.nextLine();

        System.out.println("Here are cars matching that make/model:");

        for (int i = 0; i < currentInventory; i++) {
            Vehicle car = carshop[i];
            if (car.getMakeModel().toLowerCase().contains(searchMakemodel.toLowerCase())) {
                printVehicleInfo(car);
            }
        }

    }

    public static void searchByPrice(Vehicle[] carshop, Scanner input) {

        System.out.println("What is the minimum you want to spend?");
        int minPrice = input.nextInt();
        System.out.println("What is the maximum you are willing to spend?");
        int maxPrice = input.nextInt();

        System.out.println("Here are cars that match your budget:");
        for (int i = 0; i < currentInventory; i++) {
            Vehicle car = carshop[i];
            if (minPrice <= car.getPrice() && car.getPrice() <= maxPrice) {
                printVehicleInfo(car);
            }
        }

    }

    public static void searchByColor(Vehicle[] carshop, Scanner input) {

        System.out.println("What color are you looking for?");
        String searchColor = input.nextLine();

        System.out.println("Here are cars matching that color:");
        for (int i = 0; i < currentInventory; i++) {
            Vehicle car = carshop[i];
            if (car.getColor().toLowerCase().contains(searchColor.toLowerCase())) {
                printVehicleInfo(car);
            }
        }

    }

    public static void addVehicle(Vehicle[] carshop, Scanner input) {

        Vehicle car = new Vehicle();

        System.out.println("Let's get the vehicle information first.");
        System.out.println("What is the Vehicle ID?");
        car.setVehicleID(input.nextLong());
        input.nextLine();
        System.out.println("What is the make/model?");
        car.setMakeModel(input.nextLine());
        System.out.println("What is the color?");
        car.setColor(input.nextLine());
        System.out.println("What is the odometer reading?");
        car.setOdometerReading(input.nextInt());
        System.out.println("What will be the car's price?");
        car.setPrice(input.nextFloat());
        input.nextLine();

        System.out.println("This car has been added to the inventory.");
        carshop[currentInventory] = car;
        currentInventory++;

    }

}
