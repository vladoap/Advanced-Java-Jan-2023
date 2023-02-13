package iteratorsAndComparators.strategyPattern;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Person> {
    @Override
    public int compare(Person first, Person second) {
        if (first.getName().length() == second.getName().length()) {
            return first.getName().toUpperCase().compareTo(second.getName().toUpperCase());
        }
        return first.getName().length() - second.getName().length();
    }
}
