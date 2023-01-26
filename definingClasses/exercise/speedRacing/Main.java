package definingClasses.exercise.speedRacing;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();
        while (n-- > 0) {
            String[] carData =  scanner.nextLine().split("\\s+");
            String model = carData[0];
            double fuelAmount = Double.parseDouble(carData[1]);
            double fuelCostPer1Km = Double.parseDouble(carData[2]);

            Car car = new Car(model, fuelAmount, fuelCostPer1Km);
            cars.add(car);
        }

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] carData = command.split("\\s+");
            String model = carData[1];
            double distance = Double.parseDouble(carData[2]);

            Car currentCar = cars.stream().filter(car -> car.getModel().equals(model)).findFirst().get();
            currentCar.drive(distance);


            command = scanner.nextLine();
        }

        cars.stream().forEach(System.out::println);
    }
}
