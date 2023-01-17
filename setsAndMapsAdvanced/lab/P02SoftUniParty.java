package setsAndMapsAdvanced.lab;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> vip = new TreeSet<>();
        Set<String> regular = new TreeSet<>();
        String input = scanner.nextLine();

        while (!input.equals("PARTY")) {
            if (Character.isDigit(input.charAt(0))) {
                vip.add(input);
            } else {
                regular.add(input);
            }
            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("END")) {
          vip.remove(input);
          regular.remove(input);
            input = scanner.nextLine();
        }

        int totalCount = vip.size() + regular.size();
        System.out.println(totalCount);
        vip.forEach(guest -> System.out.println(guest));
        regular.forEach(guest -> System.out.println(guest));
    }
}
