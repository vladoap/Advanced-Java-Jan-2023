package generics.exercise.genericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Box<Double> box = new Box<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n ; i++) {
            double data = Double.parseDouble(scanner.nextLine());
            box.add(data);
        }
        double elementToCompare = Double.parseDouble(scanner.nextLine());

        System.out.println(box.countOfElements(elementToCompare));

    }
}
