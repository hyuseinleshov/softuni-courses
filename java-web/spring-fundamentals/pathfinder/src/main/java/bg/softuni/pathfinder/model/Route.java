package bg.softuni.pathfinder.model;

import bg.softuni.pathfinder.model.enums.Level;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "routes")
public class Route extends BaseEntity {
    @Column(name = "gpx_coordinates", columnDefinition = "LONGTEXT")
    private String gpxCoordinates;

    private String description;

    @Column(name = "level_enum")
    @Enumerated(EnumType.STRING)
    private Level levelEnum;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    private User author;

    @Column(name = "video_url")
    private String videoUrl;

    @ManyToMany()
    @JoinTable(name = "routes_categories",
            joinColumns = @JoinColumn(name = "route_entity_id"),
            inverseJoinColumns = @JoinColumn(name = "categories_id"))
    private Set<Category> categories;

    public Route() {
        this.categories = new HashSet<>();
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Level getLevelEnum() {
        return levelEnum;
    }

    public void setLevelEnum(Level levelEnum) {
        this.levelEnum = levelEnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
