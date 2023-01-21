package functionalProgramming.exercise;

import java.util.*;
import java.util.stream.Collectors;

public class P05ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int divisor = Integer.parseInt(scanner.nextLine());

        Collections.reverse(numbers);
        numbers.stream().filter(num -> num % divisor != 0)
                .forEach(num -> System.out.print(num + " "));

    }
}
