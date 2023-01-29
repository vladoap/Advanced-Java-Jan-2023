package definingClasses.exercise.google;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         List<Person> people = new ArrayList<>();
        String line = scanner.nextLine();

        while (!line.equals("End")) {
            String[] data = line.split("\\s+");
            String name = data[0];
            switch (data[1]) {
                case "company":
                    addCompany(data, people);
                    break;
                case "pokemon":
                    addPokemon(data, people);
                    break;
                case "parents":
                    addParent(data, people);
                    break;
                case "children":
                    addChild(data, people);
                    break;
                case "car":
                    addCar(data, people);
                    break;
            }
            line = scanner.nextLine();
        }

        String name = scanner.nextLine();

        people.stream().filter(person -> person.getName().equals(name)).forEach(Person::printPersonData);
    }

    private static void addParent(String[] data, List<Person> people) {
        String personName = data[0];
        Person currentPerson = getOrCreatePerson(personName, people);
        currentPerson.addParent(data);
    }

    private static void addChild(String[] data, List<Person> people) {
        String personName = data[0];
        Person currentPerson = getOrCreatePerson(personName, people);
        currentPerson.addChild(data);
    }

    private static void addCar(String[] data, List<Person> people) {
        String personName = data[0];
        Person currentPerson = getOrCreatePerson(personName, people);
        currentPerson.addCar(data);
    }

    private static void addPokemon(String[] data, List<Person> people) {
        String personName = data[0];
        Person currentPerson = getOrCreatePerson(personName, people);
        currentPerson.addPokemon(data);
    }

    private static void addCompany(String[] data, List<Person> people) {
        String personName = data[0];
        Person currentPerson = getOrCreatePerson(personName, people);
        currentPerson.addCompany(data);
    }

    private static Person getOrCreatePerson (String name ,List<Person> people) {
        Person currentPerson = null;
        if (doesPersonExist(name, people)) {
            currentPerson = people.stream().filter(per -> per.getName().equals(name)).findFirst().get();
        } else {
            currentPerson = new Person(name);
            people.add(currentPerson);
        }
        return currentPerson;
    }

    private static boolean doesPersonExist(String person, List<Person> people) {
        return people.stream().anyMatch(per -> per.getName().equals(person));
    }
}
