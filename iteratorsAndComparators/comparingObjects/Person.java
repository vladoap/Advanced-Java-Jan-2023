package iteratorsAndComparators.comparingObjects;

public class Person implements Comparable<Person> {

    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTown() {
        return town;
    }

    @Override
    public int compareTo(Person otherPerson) {
        if (this.name.equals(otherPerson.getName())) {
            if (this.age == otherPerson.getAge()) {
                return this.town.compareTo(otherPerson.getTown());
            } else {
                return Integer.compare(this.age, otherPerson.getAge());
            }
        }
        return this.name.compareTo(otherPerson.getName());
    }
}
