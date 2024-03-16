package bg.softuni.springdataautomappingobjects.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")
public class Address extends BaseEntity {
    private String city;
    private String country;

    @Column(name = "street_name")
    private String streetName;

    public Address(String city, String country, String streetName) {
        this.city = city;
        this.country = country;
        this.streetName = streetName;
    }

    public Address() {}

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
}
