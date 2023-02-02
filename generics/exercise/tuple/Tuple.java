package generics.exercise.tuple;

public class Tuple<T, E> {

      public T first;
      public E second;

    public Tuple(T first, E second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return first.toString() + " -> " + second.toString();
    }
}
