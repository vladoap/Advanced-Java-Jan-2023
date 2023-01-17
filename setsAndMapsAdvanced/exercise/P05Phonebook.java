package setsAndMapsAdvanced.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, String> phonebookMap = new HashMap<>();

        while (!input.equals("search")) {
            String[] dataArr = input.split("-");
            String name = dataArr[0];
            String phone = dataArr[1];

            phonebookMap.put(name, phone);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("stop")) {
            String name = input;
            if (phonebookMap.containsKey(name)) {
                System.out.printf("%s -> %s%n", name, phonebookMap.get(name));
            } else {
                System.out.printf("Contact %s does not exist.%n", name);
            }

            input = scanner.nextLine();
        }

    }
}
