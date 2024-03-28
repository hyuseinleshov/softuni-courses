package bg.softuni.cardealerxml.service.dtos.exports;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerSalesRootDto {
    @XmlElement(name = "customer")
    private List<CustomerSalesDto> customers;

    public List<CustomerSalesDto> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerSalesDto> customers) {
        this.customers = customers;
    }
}
