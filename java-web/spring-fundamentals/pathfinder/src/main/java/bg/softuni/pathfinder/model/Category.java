package bg.softuni.pathfinder.model;

import bg.softuni.pathfinder.model.enums.CategoryType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private CategoryType name;

    @Column(columnDefinition = "TEXT")
    private String description;
}
