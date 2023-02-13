package iteratorsAndComparators.froggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Lake lake = new Lake(numbers);
        List<String> result = new ArrayList<>();
        for (Integer num : lake) {
            result.add(String.valueOf(num));
        }

        System.out.println(String.join(", ", result));
    }
}
