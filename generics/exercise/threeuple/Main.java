package generics.exercise.threeuple;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split("\\s+");
        Threeuple<String, String, String> firstTuple = new Threeuple<>(data[0] + " " + data[1], data[2], data[3]);
        System.out.println(firstTuple);

        data = scanner.nextLine().split("\\s+");
        Threeuple<String, Integer, String> secondTuple = new Threeuple<>(data[0],  Integer.parseInt(data[1]), data[2]);
        System.out.println(secondTuple);

        data = scanner.nextLine().split("\\s+");
        Threeuple<String, Double, String> thirdTuple = new Threeuple<>(data[0], Double.parseDouble(data[1]), data[2]);
        System.out.println(thirdTuple);
    }
}
