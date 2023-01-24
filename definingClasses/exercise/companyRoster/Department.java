package definingClasses.exercise.companyRoster;

import java.util.ArrayList;
import java.util.List;

 class Department {

    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public double getAverageSalary () {
       return this.employees.stream().mapToDouble(emp -> emp.getSalary()).average().getAsDouble();
    }


}
