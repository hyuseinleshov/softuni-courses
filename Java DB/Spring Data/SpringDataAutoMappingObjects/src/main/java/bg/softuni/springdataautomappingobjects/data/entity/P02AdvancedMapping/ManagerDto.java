package bg.softuni.springdataautomappingobjects.data.entity.P02AdvancedMapping;

import bg.softuni.springdataautomappingobjects.data.entity.P02AdvancedMapping.EmployeeDto;

import java.util.List;

public class ManagerDto {
    private String firstName;
    private String lastName;
    private List<EmployeeDto> employees;

    public ManagerDto() {}

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

    public List<EmployeeDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDto> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return String.format("%s %s | Employees: %d", firstName, lastName, employees.size());
    }
}
