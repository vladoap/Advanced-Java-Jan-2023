package streamsFilesAndDirectories.exercise;

import java.io.*;

public class P07MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        BufferedReader input1 = new BufferedReader(new FileReader("resourcesExercise/inputOne.txt"));
        BufferedReader input2 = new BufferedReader(new FileReader("resourcesExercise/inputTwo.txt"));
//        BufferedWriter output = new BufferedWriter(new FileWriter("resourcesExercise/output.txt"));
        PrintWriter printer = new PrintWriter(new FileWriter("resourcesExercise/output.txt"), true);
        input1.lines().forEach(lines -> printer.println(lines));
        input2.lines().forEach(lines -> printer.println(lines));


        input1.close();
        input2.close();
        printer.close();

    }
}
