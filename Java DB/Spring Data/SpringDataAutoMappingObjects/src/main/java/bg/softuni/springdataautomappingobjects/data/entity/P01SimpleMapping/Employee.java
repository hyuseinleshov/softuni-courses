package bg.softuni.springdataautomappingobjects.data.entity.P01SimpleMapping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Employee {
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private LocalDate birthdate;
    private String address;

    public Employee(String firstName, String lastName, BigDecimal salary, LocalDate birthdate, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.birthdate = birthdate;
        this.address = address;
    }

    public Employee() {}

    public <E> Employee(String steve, String jobbsen, LocalDate of, BigDecimal bigDecimal, boolean b, String sofia, Object o, List<E> of1) {
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

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
