package setsAndMapsAdvanced.lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Set<String> cars = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String[] inputArr = input.split(", ");
            String direction = inputArr[0];
            String carNumber = inputArr[1];
            if (direction.equals("IN")) {
                cars.add(carNumber);
            } else {
                cars.remove(carNumber);
            }

            input = scanner.nextLine();
        }

        String output = cars.isEmpty()
                ? "Parking Lot is Empty"
                : String.join(System.lineSeparator(), cars);

        System.out.println(output);
    }
}
