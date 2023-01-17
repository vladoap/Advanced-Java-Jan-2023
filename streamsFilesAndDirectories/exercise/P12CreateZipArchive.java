package streamsFilesAndDirectories.exercise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class P12CreateZipArchive {
    public static void main(String[] args) throws IOException {

        FileInputStream fis1 = new FileInputStream("resourcesExercise/words.txt");
        FileInputStream fis2 = new FileInputStream("resourcesExercise/text.txt");
        FileInputStream fis3 = new FileInputStream("resourcesExercise/result.txt");

        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("resourcesExercise/files.zip"));

        ZipEntry file1 = new ZipEntry("words.txt");
        zos.putNextEntry(file1);
        zos.write(fis1.readAllBytes());
        zos.closeEntry();


        ZipEntry file2 = new ZipEntry("text.txt");
        zos.putNextEntry(file2);
        zos.write(fis2.readAllBytes());
        zos.closeEntry();

        ZipEntry file3 = new ZipEntry("result.txt");
        zos.putNextEntry(file3);
        zos.write(fis3.readAllBytes());
        zos.closeEntry();


        zos.close();
        fis1.close();
        fis2.close();
        fis3.close();


    }
}
