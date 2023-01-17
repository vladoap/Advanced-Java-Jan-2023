package streamsFilesAndDirectories.lab;

import java.io.Serializable;

public class Cube implements Serializable {

    private String color;
    private double width;
    private double height;
    private double depth;

    Cube (String color, double width, double height, double depth) {
        this.color = color;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

}
