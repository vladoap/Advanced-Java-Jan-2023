package setsAndMapsAdvanced.lab;

import java.util.*;

public class P05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> gradesByStudents = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] studentsData = scanner.nextLine().split("\\s+");
            String name = studentsData[0];
            double grade = Double.parseDouble(studentsData[1]);
            gradesByStudents.putIfAbsent(name, new ArrayList<>());
            gradesByStudents.get(name).add(grade);
        }

       gradesByStudents.entrySet().forEach(entry -> {
           System.out.print(entry.getKey() + " -> ");
           entry.getValue().forEach(grade -> System.out.printf("%.2f ", grade));
           double average = 0;
           for (Double grade : entry.getValue()) {
               average += grade;
           }
           average = average / entry.getValue().size();
           System.out.printf("(avg: %.2f)%n", average);
       });
    }
}
