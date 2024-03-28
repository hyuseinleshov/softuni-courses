package bg.softuni.cardealerxml.service.dtos.exports;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerOrderRootDto {
    @XmlElement(name = "customer")
    private List<CustomerOrderDto> customers;

    public List<CustomerOrderDto> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerOrderDto> customers) {
        this.customers = customers;
    }
}
