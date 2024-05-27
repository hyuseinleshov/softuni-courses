package bg.softuni.pathfinder.model;

import bg.softuni.pathfinder.model.enums.CategoryType;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private CategoryType name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Route> routes;

    public Category() {
        this.routes = new HashSet<>();
    }

    public CategoryType getName() {
        return name;
    }

    public void setName(CategoryType name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
