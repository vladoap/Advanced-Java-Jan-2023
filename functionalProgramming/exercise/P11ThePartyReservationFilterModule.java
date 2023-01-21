package functionalProgramming.exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P11ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guestList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Set<String> filters = new HashSet<>();
        String command = scanner.nextLine();


        while (!command.equals("Print")) {
            String[] data = command.split(";");
            String addOrRemove = data[0];
            String filterType = data[1];
            String filterParameter = data[2];

            switch (addOrRemove) {
                case "Remove filter":
                    filters.remove(filterType + ";" + filterParameter);
                    break;
                case "Add filter":
                filters.add(filterType + ";" + filterParameter);
                    break;
            }
            command = scanner.nextLine();

         }

        filters.forEach(filter -> {
            Predicate<String> predicate = getPredicate(filter);
            guestList.removeIf(predicate);
        });

        System.out.println(String.join(" ", guestList));


    }


    private static Predicate<String> getPredicate(String filter) {
        String[] data = filter.split(";");
        String filterType = data[0];
        String filterParameter = data[1];
        switch (filterType) {
            case "Starts with":
                return name -> name.startsWith(filterParameter);
            case "Ends with":
                return name -> name.endsWith(filterParameter);
            case "Length":
                int length = Integer.parseInt(filterParameter);
                return name -> name.length() == length;
            case "Contains":
                return name -> name.contains(filterParameter);
        }
        throw new IllegalArgumentException();
    }


}
