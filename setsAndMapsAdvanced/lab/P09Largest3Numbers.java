package setsAndMapsAdvanced.lab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).sorted((n1, n2) -> n2 - n1).collect(Collectors.toList());

        int n = 3;
            for (var number : numbers) {
                System.out.print(number + " ");
                n--;
                if (n == 0) {
                    break;
                }
            }



    }
}
