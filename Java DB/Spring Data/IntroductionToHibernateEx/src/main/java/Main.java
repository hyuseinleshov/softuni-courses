import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

import entities.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

//        P02ChangeCasing(entityManager);
//        P03ContainsEmployee(entityManager, scanner);
//        P04EmployeesWithASalaryOver50_000(entityManager);
//        P05EmployeesFromDepartment(entityManager);
//        P06AddingANewAddressAndUpdatingTheEmployee(entityManager, scanner);
//        P07AddressesWithEmployeeCount(entityManager);
//        P08GetEmployeesWithProject(entityManager, scanner);
        P09FindTheLatest10Projects(entityManager);
//        P10IncreaseSalaries(entityManager);
//        P11FindEmployeesByFirstName(entityManager, scanner);
//        P12EmployeesMaximumSalaries(entityManager);
//        P13RemoveTowns(entityManager, scanner);

        entityManager.getTransaction().commit();
    }

    private static void P13RemoveTowns(EntityManager entityManager, Scanner scanner) {
        String townName = scanner.nextLine();

        List<Town> resultList = entityManager.createQuery("FROM Town WHERE name = :townName", Town.class)
                .setParameter("townName", townName)
                .getResultList();

        if (!resultList.isEmpty()) {
            Town town = resultList.get(0);

            List<Address> addresses = entityManager.createQuery("SELECT a FROM Address a JOIN a.town t WHERE t.name = :name", Address.class)
                    .setParameter("name", town.getName())
                    .getResultList();

            addresses.forEach(a -> {
                a.getEmployees().forEach(e -> {
                    e.setAddress(null);
                    entityManager.persist(e);
                });
                entityManager.remove(a);
            });

            System.out.printf("%d address in %s deleted\n", addresses.size(), town.getName());
            entityManager.remove(town);
        }

    }

        private static void P12EmployeesMaximumSalaries(EntityManager entityManager) {
        String hql = "SELECT d.name, MAX(e.salary) AS maxSalary FROM Employee e JOIN e.department d GROUP BY e.department HAVING MAX(e.salary) < 30000 OR MAX(e.salary) > 70000";
        TypedQuery<Tuple> query = entityManager.createQuery(hql, Tuple.class);
        List<Tuple> maxSalaries = query.getResultList();

        System.out.println();

        for (Tuple tuple : maxSalaries) {
            String departmentName = tuple.get(0, String.class);
            BigDecimal maxSalary = tuple.get(1, BigDecimal.class);
            System.out.printf("%s %.2f\n", departmentName, maxSalary);
        }

    }

    private static void P11FindEmployeesByFirstName(EntityManager entityManager, Scanner scanner) {
        String pattern = scanner.nextLine();

        String hql = "FROM Employee WHERE firstName LIKE :pattern";
        TypedQuery<Employee> query = entityManager.createQuery(hql, Employee.class);
        query.setParameter("pattern", pattern + "%");

        List<Employee> employees = query.getResultList();

        if (employees.isEmpty()) {
            System.out.println("No employees found with the given pattern.");
        } else {
            for (Employee employee : employees) {
                System.out.printf("%s %s - %s - ($%.2f)\n", employee.getFirstName(), employee.getLastName(), employee.getJobTitle(), employee.getSalary());
            }
        }
    }

    private static void P10IncreaseSalaries(EntityManager entityManager) {
        List<Employee> employees = entityManager
                .createQuery("SELECT e FROM Employee e JOIN e.department d WHERE d.name IN ('Engineering', 'Tool Marketing', 'Design Marketing', 'Information Services')", Employee.class)
                .getResultList();

        for (Employee employee : employees) {
            employee.setSalary(employee.getSalary().multiply(BigDecimal.valueOf(1.12)));
            entityManager.persist(employee);
            System.out.printf("%s %s - ($%.2f)\n", employee.getFirstName(), employee.getLastName(), employee.getSalary());
        }
    }

    private static void P09FindTheLatest10Projects(EntityManager entityManager) {
        TypedQuery<Project> query = entityManager.createQuery("FROM Project ORDER BY startDate DESC, name", Project.class);
        query.setMaxResults(10);
        List<Project> projects = query.getResultList();

        for (Project project : projects) {
            System.out.println("Project name: " + project.getName());
            System.out.println("    Project Description: " + project.getDescription());
            System.out.println("    Project Start Date: " + project.getStartDate());
            System.out.println("    Project End Date: " + project.getEndDate());
        }
    }

    private static void P08GetEmployeesWithProject(EntityManager entityManager, Scanner scanner) {
        int id = Integer.parseInt(scanner.nextLine());

        Employee employee = entityManager
                .createQuery("FROM Employee WHERE id = :id", Employee.class)
                .setParameter("id", id)
                .getSingleResult();

        System.out.printf("%s %s - %s\n", employee.getFirstName(), employee.getLastName(), employee.getJobTitle());

        employee.getProjects()
                .stream()
                .sorted(Comparator.comparing(Project::getName))
                        .forEach(p -> System.out.println("       " + p.getName()));
    }

    private static void P07AddressesWithEmployeeCount(EntityManager entityManager) {
        String hql = "FROM Address ORDER BY employees.size DESC";
        Query query = entityManager.createQuery(hql);
        query.setMaxResults(10);
        List<Address> employees = query.getResultList();

        employees.forEach(a -> {
            System.out.printf("%s, %s - %d employees\n", a.getText(), a.getTown(), a.getEmployees().size());
        });
    }

    private static void P06AddingANewAddressAndUpdatingTheEmployee(EntityManager entityManager, Scanner scanner) {
        String lastName = scanner.nextLine();

        Address address = new Address();
        address.setText("Vitoshka 15");

        entityManager.persist(address);

        Query query = entityManager.createQuery("UPDATE Employee e SET e.address = 292 WHERE e.lastName = :lastName");
        query.setParameter("lastName", lastName);
        query.executeUpdate();
    }

    private static void P05EmployeesFromDepartment(EntityManager entityManager) {
        String hql = "SELECT e FROM Employee e JOIN e.department d WHERE d.name = 'Research and Development' ORDER BY e.salary, e.id";
        Query query = entityManager.createQuery(hql);
        List<Employee> employees = query.getResultList();

        employees.forEach(e -> {
            System.out.printf("%s %s from Research and Development - $%.2f\n",
                    e.getFirstName(),
                    e.getLastName(),
                    e.getSalary());
        });
    }

    private static void P04EmployeesWithASalaryOver50_000(EntityManager entityManager) {
        Query query = entityManager.createQuery("SELECT e.firstName FROM Employee e WHERE salary > 50000");
        List<String> firstName = query.getResultList();
        firstName.forEach(System.out::println);
    }

    private static void P03ContainsEmployee(EntityManager entityManager, Scanner scanner) {
        String[] data = scanner.nextLine().split(" ");
        String firstName = data[0];
        String lastName = data[1];

        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee e WHERE e.firstName = :firstName AND e.lastName = :lastName", Employee.class);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);

        List<Employee> resultList = query.getResultList();

        if (!resultList.isEmpty()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static void P02ChangeCasing(EntityManager entityManager) {
        List<Town> towns = entityManager.createQuery("FROM Town", Town.class).getResultList();

        towns.forEach(town -> {
            if (town.getName().length() > 5) {
                entityManager.detach(town);
            } else {
                town.setName(town.getName().toUpperCase());
            }
        });
    }

}
