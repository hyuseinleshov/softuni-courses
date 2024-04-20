package bg.softuni.nextleveltechnologies.dto.imports;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeImportRootDTO {
    @XmlElement(name = "employee")
    private List<EmployeeImportDTO> employees;

    public List<EmployeeImportDTO> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeImportDTO> employees) {
        this.employees = employees;
    }
}
