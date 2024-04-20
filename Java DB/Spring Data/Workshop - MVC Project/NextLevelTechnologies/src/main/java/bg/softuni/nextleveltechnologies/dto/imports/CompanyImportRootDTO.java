package bg.softuni.nextleveltechnologies.dto.imports;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "companies")
@XmlAccessorType(XmlAccessType.FIELD)
public class CompanyImportRootDTO {
    @XmlElement(name = "company")
    private List<CompanyImportDTO> companies;

    public List<CompanyImportDTO> getCompanies() {
        return companies;
    }

    public void setCompanies(List<CompanyImportDTO> companies) {
        this.companies = companies;
    }
}
