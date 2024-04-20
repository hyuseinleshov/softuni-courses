package bg.softuni.nextleveltechnologies.dto.imports;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "projects")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProjectImportRootDTO {
    @XmlElement(name = "project")
    private List<ProjectImportDTO> projects;

    public List<ProjectImportDTO> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectImportDTO> projects) {
        this.projects = projects;
    }
}
