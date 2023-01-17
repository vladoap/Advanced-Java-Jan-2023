package streamsFilesAndDirectories.lab;

import java.io.*;
import java.util.ArrayDeque;

public class P08NestedFolders {
    public static void main(String[] args) throws IOException {

        File file = new File("resources/Files-and-Streams");
        PrintWriter printer = new PrintWriter(new FileOutputStream("resources/text.txt"));

        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.offer(file);
        printer.println(file.getName());
        int counter = 1;
        while (!queue.isEmpty()) {
            File currentFile = queue.poll();
            File[] files = currentFile.listFiles();
            for (File f : files) {
                if (f.isDirectory()) {
                    queue.offer(f);
                    counter++;
                    printer.println(f.getName());
                }
            }
        }
        printer.println(String.format("%d folders", counter));


        printer.close();



    }
}
