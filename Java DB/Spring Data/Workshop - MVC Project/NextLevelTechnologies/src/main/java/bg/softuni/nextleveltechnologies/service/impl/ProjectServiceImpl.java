package bg.softuni.nextleveltechnologies.service.impl;

import bg.softuni.nextleveltechnologies.dto.imports.ProjectImportDTO;
import bg.softuni.nextleveltechnologies.dto.imports.ProjectImportRootDTO;
import bg.softuni.nextleveltechnologies.model.Company;
import bg.softuni.nextleveltechnologies.model.Project;
import bg.softuni.nextleveltechnologies.repository.CompanyRepository;
import bg.softuni.nextleveltechnologies.repository.ProjectRepository;
import bg.softuni.nextleveltechnologies.service.ProjectService;
import bg.softuni.nextleveltechnologies.util.xml.XmlParser;
import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {
    private static final String FILE_IMPORT_PROJECTS_PATH = "src/main/resources/files/xmls/projects.xml";
    private final ProjectRepository projectRepository;
    private final CompanyRepository companyRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, CompanyRepository companyRepository, XmlParser xmlParser, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.companyRepository = companyRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
    }

    @Override
    public void importProjects() {
        if (projectRepository.count() == 0) {
            try {
                ProjectImportRootDTO projects = xmlParser.parse(ProjectImportRootDTO.class, FILE_IMPORT_PROJECTS_PATH);

                for (ProjectImportDTO project : projects.getProjects()) {
                    Project map = modelMapper.map(project, Project.class);

                    Company company = companyRepository.findByName(project.getCompany().getName());
                    map.setCompany(company);

                    projectRepository.save(map);
                }
            } catch (JAXBException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String exportFinishedProjects() {
        return projectRepository.findAllByIsFinishedTrue()
                .stream()
                .map(p -> String.format("Project Name: %s\n" +
                                "   Description: %s\n" +
                                "   %.2f\n",
                        p.getName(), p.getDescription(), p.getPayment()))
                .collect(Collectors.joining());
    }
}
