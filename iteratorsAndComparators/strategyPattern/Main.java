package iteratorsAndComparators.strategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Person> setComparedByName = new TreeSet<>(new ComparatorByName());
        Set<Person> setComparedByAge = new TreeSet<>(new ComparatorByAge());
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            Person person = new Person(name, age);
            setComparedByName.add(person);
            setComparedByAge.add(person);
        }

        setComparedByName.forEach(System.out::println);
        setComparedByAge.forEach(System.out::println);
    }
}
