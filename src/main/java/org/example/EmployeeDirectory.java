package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeDirectory {
    List<Employee> employees;

    public EmployeeDirectory(List<Employee> employees) {
        this.employees = employees;
    }

    public EmployeeDirectory() {
        this.employees = new ArrayList<>();
    }
    //### Добавить метод добавление нового сотрудника в справочник сотрудников
    public void add(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee must not be null");
        } else if (!employees.contains(employee)) {
            List<Employee> temp = employees.stream()
                    .filter(e -> e.getPersonnelNumber() == employee.getPersonnelNumber()
                            || e.getMobNumber() == employee.getMobNumber())
                    .collect(Collectors.toList());
            if (temp.isEmpty()) {
                employees.add(employee);
            } else {
                System.out.printf("The employee with Personnel Number '%d' or Mobile Number '%d' is already exists.\n",
                        employee.getPersonnelNumber(), employee.getMobNumber());
            }
        } else {
            System.out.printf("The employee with name '%s' already exists", employee.getName());
        }
    }

    //### Добавить метод, который ищет сотрудника по табельному номеру
    public Employee getEmployeeForPersonnelNumber(int personnelNumber) {
        List<Employee> findEmployee = employees
                .stream().filter(employee -> (employee.getPersonnelNumber() == personnelNumber))
                .collect(Collectors.toList());
        ;
        return findEmployee.get(0);
    }

    //    Добавить метод, который ищет сотрудника по стажу (может быть список)
    public List<Employee> getEmployeeForExperience(int Experience) {
        return employees.stream()
                .filter(employee -> employee.getExperience() == Experience)
                .collect(Collectors.toList());
    }

    //    ### Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
    public void getEmployMobNumber(String name) {
        List<Employee> employeeList = employees.stream()
                .filter(employee -> employee.getName().equals(name)).collect(Collectors.toList());
        employeeList.forEach(System.out::println);
    }
}
