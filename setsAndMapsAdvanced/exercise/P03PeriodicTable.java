package setsAndMapsAdvanced.exercise;

import java.util.*;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> compoundSet = new TreeSet<>();


        for (int i = 0; i < n; i++) {
            String[] compoundArr = scanner.nextLine().split("\\s+");
            compoundSet.addAll(Arrays.asList(compoundArr));
        }

        compoundSet.forEach(e -> System.out.print(e + " "));
    }
}
