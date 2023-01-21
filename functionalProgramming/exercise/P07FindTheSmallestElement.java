package functionalProgramming.exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class P07FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> function = elements -> {
            int index = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < elements.length; i++) {
                if (elements[i] <= min) {
                    min = elements[i];
                    index = i;
                }
            }
            return index;
        };

        System.out.println(function.apply(numbers));
    }
}
