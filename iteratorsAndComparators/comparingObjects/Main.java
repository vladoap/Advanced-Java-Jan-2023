package iteratorsAndComparators.comparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] data = command.split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            String town = data[2];
            people.add(new Person(name, age, town));

            command = scanner.nextLine();
        }
        int n = Integer.parseInt(scanner.nextLine());
        Person personToCompare = people.get(n - 1);
        int countEqual = 0;
        int countNotEqual = 0;
        int countTotalNumber = 0;

        for (Person person : people) {
            int result = person.compareTo(personToCompare);
            if (result == 0) {
              countEqual++;
            } else {
                countNotEqual++;
            }
            countTotalNumber++;
        }

        if (countEqual > 1) {
            System.out.println(countEqual + " " + countNotEqual + " " + countTotalNumber);
        } else {
            System.out.println("No matches");
        }


    }
}
