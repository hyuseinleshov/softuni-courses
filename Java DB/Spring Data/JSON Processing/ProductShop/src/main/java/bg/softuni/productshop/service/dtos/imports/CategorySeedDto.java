package bg.softuni.productshop.service.dtos.imports;

import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CategorySeedDto {
    @Expose
    @NotNull(message = "Name should not be null")
    @Size(min = 3, max = 15, message = "Name should be between 3 and 15 characters long")
    private String name;

    protected CategorySeedDto() {}

    public CategorySeedDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
