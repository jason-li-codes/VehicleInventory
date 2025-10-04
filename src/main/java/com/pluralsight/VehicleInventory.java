package com.pluralsight;

import java.util.*;

public class VehicleInventory {

    public static void main(String[] args) {

        Vehicle[] carshop = new Vehicle[20];
        carshop[0] = new Vehicle(101121, "Ford Explorer", "red", 45000, 13500);
        carshop[1] = new Vehicle(101122, "Toyota Camry", "blue", 60000, 11000);
        carshop[2] = new Vehicle(101123, "Chevrolet Malibu", "black", 50000, 9700);
        carshop[3] = new Vehicle(101124, "Honda Civic", "white", 70000, 7500);
        carshop[4] = new Vehicle(101125, "Subaru Outback", "green", 55000, 14500);
        carshop[5] = new Vehicle(101126, "Jeep Wrangler", "yellow", 30000, 16000);

        int currentInventory = carCounter(carshop);

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
                    addVehicle(carshop);
                case 6:
                    isRunning = false;
                    System.out.println("ENDING PROGRAM...");
                    break;
            }

        }

    }

    public static int carCounter(Vehicle[] carshop) {

        int count = 0;

        for (Vehicle car : carshop) {
            if (car != null) {
                count += 1;
            }
        }

        return count;

    }

    public static void listAllVehicles(Vehicle[] carshop) {

        for (int i = 0; i < carshop.length; i++) {
            Vehicle car = carshop[i];
            if (car != null) {
                System.out.printf("""
                    Vehicle #%d. %s %s
                    ID: %d, odometer reading: %d, price: %.2f
                    """, i, car.getColor(), car.getMakeModel(), car.getVehicleID(),
                        car.getOdometerReading(), car.getPrice());
            }
        }

    }

    public static void searchByMakemodel(Vehicle[] carshop, Scanner input) {

        System.out.println("What make/model are you looking for?");
        String searchMakemodel = input.nextLine();

        for (Vehicle car : carshop) {
            if (car.getMakeModel().contains(searchMakemodel)) {

            }
        }





    }










}
