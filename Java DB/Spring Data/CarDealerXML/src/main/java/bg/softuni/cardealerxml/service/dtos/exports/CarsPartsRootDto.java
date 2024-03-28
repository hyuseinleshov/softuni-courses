package bg.softuni.cardealerxml.service.dtos.exports;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsPartsRootDto {
    @XmlElement(name = "car")
    private List<CarsPartsDto> cars;

    public List<CarsPartsDto> getCars() {
        return cars;
    }

    public void setCars(List<CarsPartsDto> cars) {
        this.cars = cars;
    }
}
