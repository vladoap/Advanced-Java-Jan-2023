package generics.lab.listUtilities;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class ListUtils {


    public static <T extends Comparable<T>> T getMin(List<T> list) {
        return get(list, Collections::min);
    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        return get(list, Collections::max);
    }

    private static <T extends Comparable<T>> T get(List<T> list, Function<List<T>, T> function) {
        ensureNotEmpty(list);
        return function.apply(list);

    }

    private static <T> void ensureNotEmpty(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("The list is empty!");
        }
    }


}
