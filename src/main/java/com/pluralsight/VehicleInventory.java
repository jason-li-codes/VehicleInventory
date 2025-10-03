package com.pluralsight;

import java.util.*;

public class VehicleInventory {

    public static void main(String[] args) {

        Vehicle[] carshop = new Vehicle[20];
        carshop[0] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500);
        carshop[1] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        carshop[2] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700);
        carshop[3] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500);
        carshop[4] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500);
        carshop[5] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000);

        int inventory = carCounter(carshop);

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
                    listAllVehicles();
                    break;
                case 2:
                    searchByMakemodel();
                    break;
                case 3:
                    searchByPrice();
                    break;
                case 4:
                    searchByColor();
                    break;
                case 5:
                    addVehicle();
                case 6:
                    isRunning = false;
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

}
