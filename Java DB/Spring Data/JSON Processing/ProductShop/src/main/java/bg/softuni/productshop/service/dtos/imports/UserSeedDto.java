package bg.softuni.productshop.service.dtos.imports;

import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserSeedDto {
    @Expose
    @NotNull(message = "First name should not be null")
    private String firstName;

    @Expose
    @NotNull(message = "Last name should not be null")
    @Size(min = 3, message = "Last name should be at least 3 characters")
    private String lastName;

    @Expose
    @Min(value = 18, message = "Age must be greater than or equal to 18")
    private int age;

    protected UserSeedDto() {}

    public UserSeedDto(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
