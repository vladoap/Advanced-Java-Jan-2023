package streamsFilesAndDirectories.exercise;

import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;

public class P05LineNumbers {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new FileReader("resourcesExercise/inputLineNumbers.txt"));
        PrintWriter printer = new PrintWriter(new FileWriter("resourcesExercise/output.txt"));

        AtomicInteger counter = new AtomicInteger(1);
       input.lines().forEach(line -> {
           printer.println(counter.getAndIncrement() + ". " + line);


               }
        );


       input.close();
       printer.close();

    }
}
