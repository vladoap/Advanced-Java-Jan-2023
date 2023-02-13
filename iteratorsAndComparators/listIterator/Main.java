package iteratorsAndComparators.listIterator;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] commandArr = scanner.nextLine().split("\\s+");
        String[] elements = Arrays.copyOfRange(commandArr, 1, commandArr.length);

        ListyIterator data = new ListyIterator(elements);

        String command = scanner.nextLine();
        while (!command.equals("END")) {
          switch (command) {
              case "HasNext":
                  System.out.println(data.iterator().hasNext());
                  break;
              case "Print":
                  try {
                      data.print();
                  } catch (NoSuchElementException e) {
                      System.out.println(e.getMessage());
                  }
                  break;
              case "Move":
                  System.out.println(data.moveIndex());
                  break;
              case "PrintAll":
                  data.printAll();
                  break;
          }


            command = scanner.nextLine();
        }
    }
}
