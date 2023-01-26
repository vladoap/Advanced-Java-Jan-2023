package definingClasses.exercise.carSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Engine> engines = new HashMap<>();
        List<Car> cars = new ArrayList<>();

        while (n-- > 0) {
            String[] engineData = scanner.nextLine().split("\\s+");
            String model = engineData[0];
            int power = Integer.parseInt(engineData[1]);
            int displacement;
            String efficiency;
            Engine engine = null;
            if (engineData.length == 4) {
                displacement = Integer.parseInt(engineData[2]);
                efficiency = engineData[3];
                engine = new Engine(model, power, displacement, efficiency);
            } else if (engineData.length == 3) {
                if (Character.isAlphabetic(engineData[2].charAt(0))) {
                    efficiency = engineData[2];
                    engine = new Engine(model, power, efficiency);
                } else {
                    displacement = Integer.parseInt(engineData[2]);
                    engine = new Engine(model, power, displacement);
                }
            } else if (engineData.length == 2) {
                engine = new Engine(model, power);
            }

            engines.put(model, engine);
        }

        n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] carData = scanner.nextLine().split("\\s+");
            String model = carData[0];
            String engine = carData[1];
            int weight;
            String color;

            Car car = null;
            Engine currentEngine = engines.get(engine);
            if (carData.length == 4) {
                weight = Integer.parseInt(carData[2]);
                color = carData[3];
                car = new Car(model, currentEngine, weight, color);
            } else if (carData.length == 3) {
                if (Character.isAlphabetic(carData[2].charAt(0))) {
                    color = carData[2];
                    car = new Car(model, currentEngine, color);
                } else {
                    weight = Integer.parseInt(carData[2]);
                    car = new Car(model, currentEngine, weight);
                }
            } else if (carData.length == 2) {
                car = new Car(model, currentEngine);
            }

            cars.add(car);
        }

        cars.forEach(System.out::println);
    }
}
