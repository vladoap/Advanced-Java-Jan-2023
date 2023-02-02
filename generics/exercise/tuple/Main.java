package generics.exercise.tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split("\\s+");
        Tuple<String, String> firstTuple = new Tuple<>(data[0] + " " + data[1], data[2]);
        System.out.println(firstTuple);

        data = scanner.nextLine().split("\\s+");
        Tuple<String, Integer> secondTuple = new Tuple<>(data[0], Integer.parseInt(data[1]));
        System.out.println(secondTuple);

        data = scanner.nextLine().split("\\s+");
        Tuple<Integer, Double> thirdTuple = new Tuple<>(Integer.parseInt(data[0]), Double.parseDouble(data[1]));
        System.out.println(thirdTuple);

    }
}
