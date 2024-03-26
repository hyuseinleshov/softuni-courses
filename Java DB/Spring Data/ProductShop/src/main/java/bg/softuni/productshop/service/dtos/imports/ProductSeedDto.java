package bg.softuni.productshop.service.dtos.imports;

import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class ProductSeedDto {
    @Expose
    @NotNull(message = "Name should not be null")
    @Size(min = 3, message = "Name should be at leas 3 characters long")
    private String name;
    @Expose
    @NotNull(message = "Price should not be null")
    private BigDecimal price;

    protected ProductSeedDto() {}

    public ProductSeedDto(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
