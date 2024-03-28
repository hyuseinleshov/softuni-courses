package bg.softuni.cardealerxml.service.dtos.exports;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierImporterRootDto {
    @XmlElement(name = "supplier")
    private List<SupplierImporterDto> suppliers;

    public List<SupplierImporterDto> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<SupplierImporterDto> suppliers) {
        this.suppliers = suppliers;
    }
}
