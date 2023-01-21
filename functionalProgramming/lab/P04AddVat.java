package functionalProgramming.lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;
import java.util.function.UnaryOperator;

public class P04AddVat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        DoubleUnaryOperator addVat = p -> p * 1.2;
        System.out.println("Prices with VAT:");
        Arrays.stream(numbers).map(addVat).forEach(p -> System.out.println(String.format("%.2f", p)));
    }
}
