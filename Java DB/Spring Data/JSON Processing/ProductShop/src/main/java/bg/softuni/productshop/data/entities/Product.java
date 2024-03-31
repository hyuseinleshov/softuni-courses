package bg.softuni.productshop.data.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    @Column(nullable = false)
    @Size(min = 3)
    private String name;
    @NotNull
    @DecimalMin(value = "0.00")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private User buyer;

    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false)
    @NotNull
    private User seller;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "products_categories",
    joinColumns = @JoinColumn(name = "products_id"),
    inverseJoinColumns = @JoinColumn(name = "categories_id"))
    private List<Category> categories;

    protected Product() {}

    public Product(String name, BigDecimal price, User buyer, User seller, List<Category> categories) {
        this.name = name;
        this.price = price;
        this.buyer = buyer;
        this.seller = seller;
        this.categories = categories;
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

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
