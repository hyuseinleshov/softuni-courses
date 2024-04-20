package bg.softuni.nextleveltechnologies.service.impl;

import bg.softuni.nextleveltechnologies.dto.imports.EmployeeImportDTO;
import bg.softuni.nextleveltechnologies.dto.imports.EmployeeImportRootDTO;
import bg.softuni.nextleveltechnologies.model.Employee;
import bg.softuni.nextleveltechnologies.model.Project;
import bg.softuni.nextleveltechnologies.repository.EmployeeRepository;
import bg.softuni.nextleveltechnologies.repository.ProjectRepository;
import bg.softuni.nextleveltechnologies.service.EmployeeService;
import bg.softuni.nextleveltechnologies.util.xml.XmlParser;
import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final String FILE_IMPORT_EMPLOYEES_PATH = "src/main/resources/files/xmls/employees.xml";
    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ProjectRepository projectRepository, XmlParser xmlParser, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
    }

    @Override
    public void importEmployees() {
        if (employeeRepository.count() == 0) {
            try {
                EmployeeImportRootDTO employees = xmlParser.parse(EmployeeImportRootDTO.class, FILE_IMPORT_EMPLOYEES_PATH);

                for (EmployeeImportDTO employee : employees.getEmployees()) {
                    Employee map = modelMapper.map(employee, Employee.class);

                    Project project = projectRepository.findByName(map.getProject().getName());
                    map.setProject(project);

                    employeeRepository.save(map);
                }
            } catch (JAXBException e) {
                throw new RuntimeException(e);
            }

        }
    }

    @Override
    public String exportEmployeesWithAgeAbove25() {
        return employeeRepository.findAllByAgeGreaterThan(25)
                .stream()
                .map(e -> String.format("Name: %s %s\n" +
                        "   Age: %d\n" +
                        "   Project name: %s\n",
                        e.getFirstName(), e.getLastName(), e.getAge(), e.getProject().getName()))
                .collect(Collectors.joining());
    }
}
