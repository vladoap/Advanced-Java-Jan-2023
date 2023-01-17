package streamsFilesAndDirectories.lab;

import java.io.*;

public class P05WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new FileReader("resources/input.txt"));
        BufferedWriter output = new BufferedWriter(new FileWriter("resources/output.txt"));
        PrintWriter printer = new PrintWriter(output);


        String line = input.readLine();
        int counter = 1;
        while (line != null) {
            if (counter % 3 == 0) {
               printer.println(line);

            }
            counter++;
            line = input.readLine();
        }

        input.close();
        output.close();

    }
}
