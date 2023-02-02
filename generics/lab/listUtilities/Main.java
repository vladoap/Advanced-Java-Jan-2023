package generics.lab.listUtilities;

import java.util.List;

public class Main {
    public static void main(String[] args) {


           List<Integer> numbers = List.of(13,4,6,10);

        System.out.println(ListUtils.getMax(numbers));
        System.out.println(ListUtils.getMin(numbers));

        List<String> strings = List.of("a", "d", "ddd");

        System.out.println(ListUtils.getMax(strings));
        System.out.println(ListUtils.getMin(strings));
    }
}
