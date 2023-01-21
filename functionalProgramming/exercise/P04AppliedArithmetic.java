package functionalProgramming.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class P04AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        UnaryOperator<List<Integer>> add = num -> num.stream().map(n -> n + 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> subtract = num -> num.stream().map(n -> n - 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> multiply = num -> num.stream().map(n -> n * 2).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            switch (command) {
                case "add":
                 numbers = add.apply(numbers);
                 break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;
                case "print":
                    numbers.forEach(e -> System.out.print(e + " "));
                    System.out.println();
                    break;

            }


            command = scanner.nextLine();
        }


    }



}
