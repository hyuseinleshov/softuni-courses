package bg.softuni.springdataautomappingobjects;

import bg.softuni.springdataautomappingobjects.data.entity.dto.EmployeeDTO;
import bg.softuni.springdataautomappingobjects.data.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private EmployeeService employeeService;

    public CommandLineRunnerImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
//        ModelMapper modelMapper = new ModelMapper();
        //P01 - Simple Mapping
//        Employee employee = new Employee("Gosho", "Ivanov", BigDecimal.valueOf(5000), LocalDate.of(1995, 3, 20), "Tsar Boris - 34");
//
//        EmployeeDto mapped = modelMapper.map(employee, EmployeeDto.class);
//
//        System.out.printf("Mapped employee: %s %s - %.2f", mapped.getFirstName(), mapped.getLastName(), mapped.getSalary());

        //P02 - Advanced Mapping
//        Employee manager = new Employee("Steve", "Jobbsen",
//                LocalDate.of(1995, 5, 15), BigDecimal.valueOf(5000),
//                false, "Sofia", null, null);
//
//        Employee firstEmployee = new Employee("Stephen", "Bjorn",
//                LocalDate.of(1995, 5, 2), BigDecimal.valueOf(4300),
//                false, "Plovdiv", manager, null);
//
//        Employee secondEmployee = new Employee("Kirilyc", "Lefi",
//                LocalDate.of(1995, 5, 2), BigDecimal.valueOf(4400),
//                false, "Plovdiv", manager, null);
//
//        manager.setEmployees(List.of(firstEmployee, secondEmployee));
//
//        ManagerDto managerDto = modelMapper.map(manager, ManagerDto.class);
//
//        System.out.println(managerDto);
//        for (EmployeeDto emp : managerDto.getEmployees()) {
//            System.out.println(emp);
//        }

        //P03 - Projection
        List<EmployeeDTO> employees = this.employeeService.findInfoForBornBefore(LocalDate.of(1990, 1, 1));

        employees.forEach(e -> System.out.println(String.format("%s %s %.2f - Manager: %s", e.getFirstName(), e.getLastName(), e.getSalary(),
                e.getManagerLastName() != null ? e.getManagerLastName() : "[no manager]")));
    }
}