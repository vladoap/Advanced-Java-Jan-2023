package setsAndMapsAdvanced.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, String> emailsByPersons = new LinkedHashMap<>();
        while (!input.equals("stop")) {
            String name = input;
            String email = scanner.nextLine();

            if (!email.endsWith(".us") && !email.endsWith(".uk") && !email.endsWith(".com")) {
                emailsByPersons.put(name, email);
            }
            input = scanner.nextLine();
        }

        emailsByPersons.entrySet().forEach(entry -> System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue()));
    }
}
