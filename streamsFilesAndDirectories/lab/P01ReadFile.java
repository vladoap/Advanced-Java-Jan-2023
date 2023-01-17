package streamsFilesAndDirectories.lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

public class P01ReadFile {
    public static void main(String[] args) throws IOException {

        String path = "resources/input.txt";
        FileInputStream input = new FileInputStream(path);

        int bytes = input.read();

        while (bytes != -1) {
            String outputText = Integer.toBinaryString(bytes);
            System.out.print(outputText + " ");

            bytes = input.read();
        }

        input.close();



    }

}
