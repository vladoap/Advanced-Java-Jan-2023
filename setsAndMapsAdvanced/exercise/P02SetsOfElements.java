package setsAndMapsAdvanced.exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lengthSetOne = scanner.nextInt();
        int lengthSetTwo = scanner.nextInt();

        Set<Integer> setOne = new LinkedHashSet<>();
        Set<Integer> setTwo = new LinkedHashSet<>();



        for (int i = 1; i <= lengthSetOne ; i++) {
           setOne.add(scanner.nextInt());
        }

        for (int i = 1; i <= lengthSetTwo ; i++) {
            setTwo.add(scanner.nextInt());
        }

        setOne.retainAll(setTwo);
        setOne.forEach(e -> System.out.print(e + " "));


    }
}
