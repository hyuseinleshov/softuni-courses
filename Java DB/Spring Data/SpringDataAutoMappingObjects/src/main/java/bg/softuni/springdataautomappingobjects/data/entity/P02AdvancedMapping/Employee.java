package bg.softuni.springdataautomappingobjects.data.entity.P02AdvancedMapping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private BigDecimal salary;
    private boolean isOnHoliday;
    private String address;
    private Employee manager;
    private List<Employee> employees;

    public Employee(String firstName, String lastName, LocalDate birthdate, BigDecimal salary, boolean isOnHoliday, String address, Employee manager, List<Employee> employees) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.salary = salary;
        this.isOnHoliday = isOnHoliday;
        this.address = address;
        this.manager = manager;
        this.employees = employees;
    }

    protected Employee() {
        this.employees = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public boolean isOnHoliday() {
        return isOnHoliday;
    }

    public void setOnHoliday(boolean onHoliday) {
        isOnHoliday = onHoliday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
