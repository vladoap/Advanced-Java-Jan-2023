package multidimensionalArrays;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LiveDemo {
    Scanner scanner = new Scanner(System.in);
    List<String> test = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
}
