package streamsFilesAndDirectories.lab;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class P03CopyBytes {
    public static void main(String[] args) throws IOException {

        FileReader input = new FileReader("resources/input.txt");
        FileWriter output = new FileWriter("resources/output.txt");
        PrintWriter printer = new PrintWriter(output);
        int bytes = input.read();
        while (bytes != -1) {
            char symbol = (char) bytes;
            boolean isSpace = symbol == ' ' || symbol == '\n';
            if (isSpace) {
                printer.print(symbol);
            } else {
                printer.print((int) symbol);
            }

            bytes = input.read();
        }

        input.close();
        output.close();
    }
}
