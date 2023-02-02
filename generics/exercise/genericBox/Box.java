package generics.exercise.genericBox;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Comparable<T>> {

    private List<T> stringList;

    public Box() {
        this.stringList = new ArrayList<>();
    }

    public void add (T string) {
        stringList.add(string);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T string : stringList) {
            System.out.println(String.format("%s: %s", string.getClass().getName(), string));
        }
        return sb.toString();
    }

    public void swap(int firstIndex, int secondIndex) {
        T temp = stringList.get(firstIndex);
        stringList.set(firstIndex, stringList.get(secondIndex));
        stringList.set(secondIndex, temp);
    }

    public int countOfElements(T elementToCompare) {
        return (int) stringList.stream().filter(e -> e.compareTo(elementToCompare) > 0).count();
    }
}
