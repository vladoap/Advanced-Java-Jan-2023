package functionalProgramming.lab;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class P05FilterByAge {
    public static class Person {
        public String name;
        public int age;

        Person (String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Function<Scanner, Person> function = sc -> {
            String[] data = scanner.nextLine().split(", ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            return new Person(name, age);
        };

        List<Person> persons = IntStream.rangeClosed(1, n)
                .mapToObj(i -> function.apply(scanner))
                .collect(Collectors.toList());

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Person> ageFilter = getPredicate(condition, age);
        Consumer<Person> printer = getPrinter(format);

        persons.stream()
                .filter(ageFilter)
                .forEach(printer);




    }

    private static Consumer<Person> getPrinter(String format) {

        switch (format) {
            case "name":
               return person -> System.out.println(person.name);
            case "age":
                return person -> System.out.println(person.age);
            case "name age":
             return person -> System.out.println(person.name + " - " + person.age);
        }
        return null;
    }

    private static Predicate<Person> getPredicate(String condition, int age) {
        if (condition.equals("older")) {
            return person -> person.age >= age;
        } else if (condition.equals("younger")){
           return person -> person.age <= age;
        }
        throw new IllegalArgumentException();
    }
}
