package examPreparation.softUni;

import java.util.*;

public class SoftUni {
    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return data.size();
    }

    public String insert (Student student) {
        if (isStudentExists(student)) {
            return "Student is already in the hall.";
        } else if (data.size() < capacity) {
            data.add(student);
            return String.format("Added student %s %s.", student.getFirstName(), student.getLastName());
        } else {
            return "The hall is full";
        }
    }



    public String remove (Student student) {
       if (isStudentExists(student)) {
           data.remove(student);
           return String.format("Removed student %s %s.", student.getFirstName(), student.getLastName());
       } else {
           return "Student not found.";
       }
    }

    public Student getStudent(String firstName, String lastName) {
        return data.stream().filter(st -> st.getFirstName().equals(firstName) && st.getLastName().equals(lastName)).findFirst().get();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Hall size: %d", data.size()));
        for (Student student : data) {
            sb.append(System.lineSeparator())
                    .append(student.toString());
        }
        return sb.toString();
    }

    private boolean isStudentExists(Student student) {
        return data.stream().anyMatch(st -> st.getFirstName().equals(student.getFirstName())
                && st.getLastName().equals(student.getLastName()));
    }
}
