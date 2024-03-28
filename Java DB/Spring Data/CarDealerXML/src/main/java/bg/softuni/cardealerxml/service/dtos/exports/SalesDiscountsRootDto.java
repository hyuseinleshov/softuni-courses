package bg.softuni.cardealerxml.service.dtos.exports;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "sales")
@XmlAccessorType(XmlAccessType.FIELD)
public class SalesDiscountsRootDto {
    @XmlElement(name = "sale")
    private List<SalesDiscountsDto> sales;

    public List<SalesDiscountsDto> getSales() {
        return sales;
    }

    public void setSales(List<SalesDiscountsDto> sales) {
        this.sales = sales;
    }
}
