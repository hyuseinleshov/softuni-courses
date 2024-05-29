package bg.softuni.pathfinder.model;

import bg.softuni.pathfinder.model.enums.Level;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "routes")
public class Route extends BaseEntity {
    @Column(columnDefinition = "LONGTEXT")
    private String gpxCoordinates;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private Level level;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    private String videoUrl;

    @ManyToMany()
    @JoinTable(name = "routes_categories",
            joinColumns = @JoinColumn(name = "route_entity_id"),
            inverseJoinColumns = @JoinColumn(name = "categories_id"))
    private Set<Category> categories;

    public Route() {
        this.categories = new HashSet<>();
    }
}
