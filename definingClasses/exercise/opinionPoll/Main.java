package definingClasses.exercise.opinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();
        while (n-- > 0) {
            String[] dataArr = scanner.nextLine().split("\\s+");
            String name = dataArr[0];
            int age = Integer.parseInt(dataArr[1]);

            people.add(new Person(name, age));
        }

        people.stream().filter(person -> person.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }

}
