package setsAndMapsAdvanced.lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> numbersOccurrence = new LinkedHashMap<>();

        for (double number : numbers) {
            numbersOccurrence.putIfAbsent(number, 0);
            int occurrence = numbersOccurrence.get(number) + 1;
            numbersOccurrence.put(number, occurrence);
        }

        numbersOccurrence.entrySet().forEach(entry -> {
            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        });
    }
}
