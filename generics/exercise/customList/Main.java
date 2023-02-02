package generics.exercise.customList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> list = new CustomList<>();
        String command = scanner.nextLine();

        while (!command.equals("END")) {
            String[] data = command.split("\\s+");
            switch (data[0]) {
                case "Add":
                    list.add(data[1]);
                    break;
                case "Remove":
                   String removedElement = list.remove(Integer.parseInt(data[1]));
                    break;
                case "Contains":
                    System.out.println(list.contains(data[1]));
                    break;
                case "Swap":
                    int index1 = Integer.parseInt(data[1]);
                    int index2 = Integer.parseInt(data[2]);
                    list.swap(index1, index2);
                    break;
                case "Greater":
                    System.out.println(list.countGreaterThan(data[1]));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Sort":
                    Sorter.sort(list);
                    break;
                case "Print":
                    System.out.println(list);
                    break;

            }
            command = scanner.nextLine();
        }



    }
}
