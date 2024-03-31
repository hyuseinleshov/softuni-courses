package bg.softuni.productshop.data.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Size(min = 3)
    private String lastName;

    @Min(0)
    private int age;

    @OneToMany(mappedBy = "seller", fetch = FetchType.EAGER)
    private List<Product> soldProducts;

    @OneToMany(mappedBy = "buyer", fetch = FetchType.EAGER)
    private List<Product> boughtProducts;

    @ManyToMany
    @JoinTable(name = "users_friends",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "friend_id"))
    private List<User> friends;

    protected User() {}

    public User(String firstName, String lastName, int age, List<Product> productsSold, List<Product> productsBought, List<User> friends) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.soldProducts = productsSold;
        this.boughtProducts = productsBought;
        this.friends = friends;
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

    public List<Product> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<Product> productsSold) {
        this.soldProducts = productsSold;
    }

    public List<Product> getBoughtProducts() {
        return boughtProducts;
    }

    public void setBoughtProducts(List<Product> productsBought) {
        this.boughtProducts = productsBought;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }
}
