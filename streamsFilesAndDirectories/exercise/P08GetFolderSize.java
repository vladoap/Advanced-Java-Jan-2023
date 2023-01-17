package streamsFilesAndDirectories.exercise;

import java.io.File;

public class P08GetFolderSize {
    public static void main(String[] args) {

        File file = new File("resourcesExercise/Exercises Resources");
        System.out.printf("Folder size: %d", file.length());

    }
}
