package functionalProgramming.exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.*;
import java.util.stream.IntStream;

public class P09ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] divisors = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

//        BiConsumer<int[], Integer> function = (div, num) -> {
//            boolean isDivisible = true;
//            for (int divisor : div) {
//                if (num % divisor != 0) {
//                    isDivisible = false;
//                    break;
//                }
//            }
//            if (isDivisible) {
//                System.out.print(num + " ");
//            }
//        };


//        IntStream.rangeClosed(1, n).forEach(i -> function.accept(divisors, i));

        Predicate<Integer> isDivided = num -> {
            for (int div : divisors) {
                if (num % div != 0) {
                    return false;
                }
            }
            return true;

        };

        IntStream.rangeClosed(1, n).boxed().filter(isDivided).forEach(num -> System.out.print(num + " "));
    }
}
