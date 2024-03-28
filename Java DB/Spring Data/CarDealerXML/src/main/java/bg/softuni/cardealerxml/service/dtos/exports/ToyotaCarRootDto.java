package bg.softuni.cardealerxml.service.dtos.exports;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class ToyotaCarRootDto {
    @XmlElement(name = "car")
    private List<ToyotaCarDto> cars;

    public List<ToyotaCarDto> getCars() {
        return cars;
    }

    public void setCars(List<ToyotaCarDto> cars) {
        this.cars = cars;
    }
}
