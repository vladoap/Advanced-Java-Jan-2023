package streamsFilesAndDirectories.lab;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

public class P07ListFiles {
    public static void main(String[] args) throws IOException {

        File file = new File("resources/Files-and-Streams");

        PrintWriter printer = new PrintWriter(new FileWriter("resources/test.txt"));

        File[] files = file.listFiles();
        for (File currentFile : files) {
            if (currentFile.isFile()) {
               printer.println(String.format("%s: [%d]", currentFile.getName(), currentFile.length()));
            }
        }

        printer.close();
    }
}
