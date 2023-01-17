package streamsFilesAndDirectories.exercise;

import java.io.Serializable;

public class Course implements Serializable {
     String name;
     int countStudents;

    Course (String name, int students) {
        this.name = name;
        this.countStudents = students;
    }
}
