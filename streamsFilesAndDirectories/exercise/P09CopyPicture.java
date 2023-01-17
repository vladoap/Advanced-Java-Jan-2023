package streamsFilesAndDirectories.exercise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class P09CopyPicture {
    public static void main(String[] args) throws IOException {

        FileInputStream picture = new FileInputStream("resourcesExercise/picture.jpg");
        FileOutputStream copiedPicture = new FileOutputStream("resourcesExercise/picture-copy.jpg");

        byte[] b = new byte[1024];
        while (picture.read(b) >= 0) {
            copiedPicture.write(b);
        }
    }
}
