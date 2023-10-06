package Exercises.P02CompanyRoster;

import org.w3c.dom.ls.LSInput;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Employee>> departments = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {

            String[] tokens = scanner.nextLine().split("\\s+");

            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            Employee employee = null;
            if (tokens.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (tokens.length == 5) {
                if (Character.isDigit(tokens[4].charAt(0))) {
                    employee = new Employee(name, salary, position, department, Integer.parseInt(tokens[4]));
                } else {
                    employee = new Employee(name, salary, position, department, tokens[4]);
                }
            } else if (tokens.length == 6) {
                employee = new Employee(name, salary, position, department, tokens[4], Integer.parseInt(tokens[5]));
            }

            if (!departments.containsKey(department)) {
                departments.put(department, new ArrayList<>());
                departments.get(department).add(employee);
            } else {
                departments.get(department).add(employee);
            }
        }

        String highestSalaryDepartment = "";
        double highestAverageSalary = 0;

        for (Map.Entry<String, List<Employee>> department : departments.entrySet()) {

            double sumSalary = 0;

            for (int i = 0; i < department.getValue().size(); i++) {
                sumSalary += department.getValue().get(i).getSalary();
            }

            double averageSalary = sumSalary / department.getValue().size();

            if (averageSalary > highestAverageSalary) {
                highestAverageSalary = averageSalary;
                highestSalaryDepartment = department.getKey();
            }
        }

        System.out.println("Highest Average Salary: " + highestSalaryDepartment);
        List<Employee> highestPaid = departments.get(highestSalaryDepartment)
                .stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());

        Collections.reverse(highestPaid);

        highestPaid.forEach(System.out::println);

    }

}
