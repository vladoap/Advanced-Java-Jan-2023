package functionalProgramming.lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P02SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<String, Integer> function = e -> Integer.parseInt(e);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                        .map(function)
                         .collect(Collectors.toList());




        int sum = numbers.stream().mapToInt(e -> e).sum();
        System.out.println("Count = " + numbers.size());
        System.out.println("Sum = " + sum);


    }
}
