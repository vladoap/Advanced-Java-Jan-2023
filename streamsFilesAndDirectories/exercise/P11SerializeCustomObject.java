package streamsFilesAndDirectories.exercise;

import java.io.*;

public class P11SerializeCustomObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

       Course course = new Course("SoftUni", 450 );

        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("resourcesExercise/course.ser"));

        output.writeObject(course);

        ObjectInputStream input = new ObjectInputStream(new FileInputStream("resourcesExercise/course.ser"));

        Course inputCourse = (Course) input.readObject();

        System.out.println(inputCourse.name + " " + inputCourse.countStudents);

        input.close();
        output.close();


    }
}
