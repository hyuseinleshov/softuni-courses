package bg.softuni.nextleveltechnologies;

import bg.softuni.nextleveltechnologies.service.CompanyService;
import bg.softuni.nextleveltechnologies.service.EmployeeService;
import bg.softuni.nextleveltechnologies.service.ProjectService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final CompanyService companyService;
    private final ProjectService projectService;
    private final EmployeeService employeeService;

    public CommandLineRunnerImpl(CompanyService companyService, ProjectService projectService, EmployeeService employeeService) {
        this.companyService = companyService;
        this.projectService = projectService;
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Imports
//        companyService.importCompanies();
//        projectService.importProjects();
//        employeeService.importEmployees();

        // Finished Projects
//        System.out.println(projectService.exportFinishedProjects());

        // Employees with Age Above 25
//        System.out.println(employeeService.exportEmployeesWithAgeAbove25());
    }
}
