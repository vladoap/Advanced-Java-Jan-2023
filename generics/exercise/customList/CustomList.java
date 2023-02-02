package generics.exercise.customList;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {

    private List<T> list;


    public CustomList () {
        list = new ArrayList<>();
    }

    public void add(T element) {
        list.add(element);
    }

    public T remove(int index) {
      return list.remove(index);
    }


    public boolean contains(T element) {
        return list.contains(element);
    }

    public void swap(int index1, int index2) {
        Collections.swap(list, index1, index2);
    }

    public int countGreaterThan(T element) {
        return (int) list.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T getMax() {
        return Collections.max(list);
    }

    public T getMin() {
        return Collections.min(list);
    }

    public int size() {
        return list.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T e : list) {
            sb.append(e).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    public T get(int i) {
        return list.get(i);
    }
}
