package definingClasses.lab.carConstructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] carData = scanner.nextLine().split("\\s+");
            String brand = carData[0];
            Car car = null;
            if (carData.length == 1) {
                car = new Car(brand);
                cars.add(car);
            } else {
                String model = carData[1];
                int hp = Integer.parseInt(carData[2]);

                car = new Car(brand, model, hp);
                cars.add(car);
            }


        }

        cars.forEach(car -> System.out.println(car.carInfo()));

    }
}
