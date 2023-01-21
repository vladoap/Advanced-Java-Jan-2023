package functionalProgramming.lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class P06FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] rangeNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int startNumber = rangeNumbers[0];
        int endNumber = rangeNumbers[1];
        String evenOrOdd = scanner.nextLine();

        Predicate<Integer> filterNums = getPredicate(evenOrOdd);
        IntStream.rangeClosed(startNumber, endNumber).boxed().filter(filterNums)
                .forEach(num -> System.out.print(num + " "));




    }

    private static Predicate<Integer> getPredicate(String evenOrOdd) {
        switch (evenOrOdd) {
            case "even":
                return num -> num % 2 == 0;
            case "odd":
               return num -> num % 2 != 0;
        }
        return null;
    }
}
