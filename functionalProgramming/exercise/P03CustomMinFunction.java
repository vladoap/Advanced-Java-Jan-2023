package functionalProgramming.exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> findMinNum = nums -> {
            int minNum = Arrays.stream(nums).min().getAsInt();
            return minNum;
        };

        System.out.println(findMinNum.apply(numbers));

    }
}
