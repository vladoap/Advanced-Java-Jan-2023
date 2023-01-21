package functionalProgramming.lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P03CountUppercaseWords {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

        List<String> words = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Predicate<String> isUpperCase = word -> Character.isUpperCase(word.charAt(0));
        ArrayDeque<String> queue = new ArrayDeque<>();

        words.stream().filter(isUpperCase).forEach(queue::offer);

        System.out.println(queue.size());

        words.stream().filter(isUpperCase).forEach(System.out::println);


    }
}
