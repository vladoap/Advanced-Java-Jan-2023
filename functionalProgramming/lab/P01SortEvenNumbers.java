package functionalProgramming.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        Predicate<Integer> isEven = number -> number % 2 == 0;


        System.out.println(numbers.stream().filter(isEven).map(String::valueOf).collect(Collectors.joining(", ")));
        System.out.println(numbers.stream().filter(isEven).sorted(Integer::compareTo).map(String::valueOf).collect(Collectors.joining(", ")));

        

    }
}
