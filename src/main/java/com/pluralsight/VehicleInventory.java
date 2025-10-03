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
