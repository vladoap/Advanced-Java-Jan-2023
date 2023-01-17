package streamsFilesAndDirectories.exercise;

import java.io.*;
import java.util.Locale;

public class P03AllCapitals {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new FileReader("resourcesExercise/input.txt"));
        BufferedWriter output = new BufferedWriter(new FileWriter("resourcesExercise/output.txt"));

        String line = input.readLine();

        while (line != null) {
            output.write(line.toUpperCase(Locale.ROOT));
            output.newLine();

            line = input.readLine();
        }
        input.close();
        output.close();

    }
}
