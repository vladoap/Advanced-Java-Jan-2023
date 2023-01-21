package functionalProgramming.exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P10PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guestList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());


        String command = scanner.nextLine();

        while (!command.equals("Party!")) {
            String[] data = command.split("\\s+");
            String removeOrDouble = data[0];
            String criteria = data[1];
            String token = data[2];

            Predicate<String> predicate = getPredicate(criteria, token);
            switch (removeOrDouble) {
                case "Remove":
                guestList.removeIf(predicate);
                break;
                case "Double":
                    for (int i = 0; i < guestList.size(); i++) {
                        String currentName = guestList.get(i);
                        if (predicate.test(currentName)) {
                            guestList.add(guestList.indexOf(currentName), currentName);
                            i++;
                        }
                    }
                    break;
            }


            command = scanner.nextLine();
        }

        if (guestList.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            String collectString = guestList.stream().sorted().collect(Collectors.joining(", "));
            System.out.println(collectString + " are going to the party!");
        }


    }

    private static Predicate<String> getPredicate(String criteria, String token) {
        switch (criteria) {
            case "StartsWith":
                return name -> name.startsWith(token);
            case "EndsWith":
                return name -> name.endsWith(token);
            case "Length":
                int length = Integer.parseInt(token);
                return name -> name.length() == length;
        }
        return null;
    }
}
