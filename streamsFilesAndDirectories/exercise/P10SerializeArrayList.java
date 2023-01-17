package streamsFilesAndDirectories.exercise;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class P10SerializeArrayList {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        List<Double> list = new ArrayList<>();
        list.add(2.0);
        list.add(3.0);
        list.add(12.5);


       ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("resourcesExercise/list.ser"));
       output.writeObject(list);

       ObjectInputStream input = new ObjectInputStream(new FileInputStream("resourcesExercise/list.ser"));

        List listInput = (List) input.readObject();
        for (Object li : listInput) {
            System.out.println(li);

        }


        output.close();
       input.close();



    }
}
