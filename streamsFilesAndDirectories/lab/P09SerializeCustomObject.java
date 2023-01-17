package streamsFilesAndDirectories.lab;

import java.io.*;

public class P09SerializeCustomObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("resources/output.txt"));
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("resources/output.txt"));

        String color = "green";
        double width = 15.3;
        double height = 12.4;
        double depth = 3.0;

        Cube cube = new Cube(color, width, height, depth);

        output.writeObject(cube);


        Cube cubeToRead = (Cube) input.readObject();

    }
}
