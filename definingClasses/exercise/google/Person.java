package definingClasses.exercise.google;

import java.util.ArrayList;
import java.util.List;

 class Person {

    private String name;
    private Company company;
    private Car car;
    private List<Parent> parents;
    private List<Child> children;
    private List<Pokemon> pokemons;

    Person (String name) {
        this.name = name;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    private class Company  {
       private String name;
       private String department;
       private double salary;

        private String getName() {
            return name;
        }

        @Override
        public String toString() {
            return String.format("%s %s %.2f", name, department, salary);
        }
    }

   private class Car {
        private String model;
        private int speed;

       @Override
       public String toString() {
           return String.format("%s %d", model, speed);
       }
    }

    private class Parent {
        private String name;
        private String birthday;

        @Override
        public String toString() {
            return String.format("%s %s", name, birthday);
        }
    }

    private class Child {
        private String name;
        private String birthday;

        @Override
        public String toString() {
            return String.format("%s %s", name, birthday);
        }
    }

    private class Pokemon {
        private String name;
        private String type;

        @Override
        public String toString() {
            return String.format("%s %s", name, type);
        }
    }

    public void addCompany (String[] data) {
        Company company = new Company();
        company.name = data[2];
        company.department = data[3];
        company.salary = Double.parseDouble(data[4]);
        this.company = company;
    }

    public void addCar (String[] data) {
        Car car = new Car();
        car.model = data[2];
        car.speed = Integer.parseInt(data[3]);
        this.car = car;
    }

    public void addPokemon (String[] data) {
        Pokemon pokemon = new Pokemon();
        pokemon.name = data[2];
        pokemon.type = data[3];
        this.pokemons.add(pokemon);
    }

    public void addParent (String[] data) {
        Parent parent = new Parent();
        parent.name = data[2];
        parent.birthday = data[3];
        this.parents.add(parent);
    }

    public void addChild (String[] data) {
        Child child = new Child();
        child.name = data[2];
        child.birthday = data[3];
        this.children.add(child);
    }


    public String getName() {
        return this.name;
    }

    public void printPersonData() {
        StringBuilder sb = new StringBuilder();
        System.out.println(name);
        System.out.println("Company:");
        if (company != null) {
            System.out.println(company);
        }
        System.out.println("Car:");
        if (car != null) {
            System.out.println(car);
        }
        System.out.println("Pokemon:");
        if (!pokemons.isEmpty()) {
            pokemons.forEach(System.out::println);
        }
        System.out.println("Parents:");
        if (!parents.isEmpty()) {
            parents.forEach(System.out::println);
        }
        System.out.println("Children:");
        if (!children.isEmpty()) {
            children.forEach(System.out::println);
        }

    }
}

