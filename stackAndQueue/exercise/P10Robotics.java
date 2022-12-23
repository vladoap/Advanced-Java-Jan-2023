package stackAndQueue.exercise;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Scanner;

public class P10Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split(";");
        String[] robots = new String[inputArr.length];
        int[] processingTime = new int[inputArr.length];
        int[] workingTime = new int[inputArr.length];

        for (int i = 0; i < inputArr.length; i++) {
            String robot = inputArr[i].split("-")[0];
            int processTime = Integer.parseInt(inputArr[i].split("-")[1]);
            robots[i] = robot;
            processingTime[i] = processTime;
        }

        String startingTime = scanner.nextLine();

        ArrayDeque<String> productQueue = new ArrayDeque<>();
        String inputProduct = scanner.nextLine();

        while (!inputProduct.equals("End")) {
            productQueue.offer(inputProduct);
            inputProduct = scanner.nextLine();
        }

        String[] timeData = startingTime.split(":");
        int hours = Integer.parseInt(timeData[0]);
        int minutes = Integer.parseInt(timeData[1]);
        int seconds = Integer.parseInt(timeData[2]);

        int startSeconds = hours * 3600 + minutes * 60 + seconds;

       while (!productQueue.isEmpty()) {
           startSeconds++;

           boolean isAvailableRobot = true;

           String currentProduct = productQueue.poll();

           for (int i = 0; i < robots.length; i++) {
               if (workingTime[i] == 0 && isAvailableRobot) {
                   workingTime[i] = processingTime[i];
                   printRobotData(robots[i], currentProduct, startSeconds);
                   isAvailableRobot = false;
               }

               if (workingTime[i] > 0) {
                   workingTime[i]--;
               }
           }

           if (isAvailableRobot) {
               productQueue.offer(currentProduct);
           }




       }


    }

    private static void printRobotData(String robot, String currentProduct, int startingTime) {
        int hours = (startingTime / 3600) % 24;
        int minutes = (startingTime / 60) % 60;
        int seconds = startingTime % 60;

        System.out.println(robot + " - " + currentProduct + String.format(" [%02d:%02d:%02d]",
                hours, minutes, seconds));


    }
}
