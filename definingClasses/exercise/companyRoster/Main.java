package definingClasses.exercise.companyRoster;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Department> departments = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] dataArr = scanner.nextLine().split("\\s+");
            String name = dataArr[0];
            double salary = Double.parseDouble(dataArr[1]);
            String position = dataArr[2];
            String employeeDepartment = dataArr[3];
            Employee employee = null;

            if (dataArr.length == 4) {
               employee = new Employee(name, salary, position, employeeDepartment);
            } else if (dataArr.length == 5) {
                if (dataArr[4].contains("@")) {
                    String email = dataArr[4];
                    employee = new Employee(name, salary, position, employeeDepartment, email);
                } else {
                    int age = Integer.parseInt(dataArr[4]);
                    employee = new Employee(name, salary, position, employeeDepartment, age);
                }
            } else if (dataArr.length == 6) {
                String email = dataArr[4];
                int age = Integer.parseInt(dataArr[5]);
                employee = new Employee(name, salary, position, employeeDepartment, email, age);
            }

            boolean departmentExists = departments.stream().anyMatch(dep -> dep.getName().equals(employeeDepartment));
            if (!departmentExists) {
                Department department = new Department(employeeDepartment);
                departments.add(department);
            }

            Department currentDepartment = departments.stream()
                            .filter(dep -> dep.getName().equals(employeeDepartment))
                            .findFirst().get();

            currentDepartment.getEmployees().add(employee);

         }

        Department highestPaidDepartment = departments.stream().max(Comparator.comparingDouble(Department::getAverageSalary)).get();

        System.out.printf("Highest Average Salary: %s%n", highestPaidDepartment.getName());

        highestPaidDepartment.getEmployees()
                .stream()
                .sorted((left ,right) -> Double.compare(right.getSalary(), left.getSalary()))
                .forEach(System.out::println);


    }

}
