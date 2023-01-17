package streamsFilesAndDirectories.lab;

import java.io.*;
import java.util.Scanner;

public class P04ExtractIntegers {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new FileReader("resources/input.txt"));
        FileWriter output = new FileWriter("resources/output.txt");
        PrintWriter printer = new PrintWriter(output);


        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                printer.println(scanner.nextInt());
            }
            scanner.next();
        }

        scanner.close();
        output.close();
    }
}
