package streamsFilesAndDirectories.lab;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class P02WriteToFile {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        FileReader input = new FileReader("resources/input.txt");
        FileWriter output = new FileWriter("resources/output.txt");

        Set<Character> punctuation = Set.of(',', '.', '!', '?');
        int bytes = input.read();

        while (bytes != -1) {
            char currentSymbol = (char) bytes;
            boolean isPunctuation = punctuation.contains(currentSymbol);

            if (!isPunctuation) {
                output.write(currentSymbol);
            }

           bytes = input.read();
        }

        input.close();
        output.close();


    }
}
