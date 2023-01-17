package streamsFilesAndDirectories.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class P02SumBytes {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new FileReader("resourcesExercise/input.txt"));

        String line = input.readLine();
        int sumSymbolsLine = 0;
        while (line != null) {

            for (char symbol : line.toCharArray()) {
                sumSymbolsLine += symbol;
            }



            line = input.readLine();
        }
        System.out.println(sumSymbolsLine);
        input.close();
    }
}
