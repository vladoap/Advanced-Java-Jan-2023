package streamsFilesAndDirectories.exercise;

import java.io.*;

public class P01SumLines {
    public static void main(String[] args) throws IOException {


        BufferedReader input = new BufferedReader(new FileReader("resourcesExercise/input.txt"));

        String line = input.readLine();
        while (line != null) {
            int sumSymbolsLine = 0;
            for (char symbol : line.toCharArray()) {
                sumSymbolsLine += symbol;
            }
            System.out.println(sumSymbolsLine);


            line = input.readLine();
        }
        input.close();



    }
}
