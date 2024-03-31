package bg.softuni.softunigamestorefix.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "games")
public class Game extends BaseEntity {
    @NotBlank
    private String title;

    @NotBlank
    private String trailer;

    @NotBlank
    @Column(name = "image_thumbnail")
    private String imageThumbnail;

    @NotNull
    private Double size;

    @NotNull
    private Double price;

    @NotBlank
    private String description;

    @NotNull
    @Column(name = "release_date")
    private LocalDate releaseDate;

    protected Game() {}

    public Game(String title, String trailer, String imageThumbnail, Double size, Double price, String description, LocalDate releaseDate) {
        this.title = title;
        this.trailer = trailer;
        this.imageThumbnail = imageThumbnail;
        this.size = size;
        this.price = price;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Title: " + getTitle() + System.lineSeparator()
                + System.lineSeparator()
                + "Price: " + getPrice() + System.lineSeparator()
                + System.lineSeparator()
                + "Description: " + getDescription() + System.lineSeparator()
                + System.lineSeparator()
                + "Release date: " + getReleaseDate();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getImageThumbnail() {
        return imageThumbnail;
    }

    public void setImageThumbnail(String imageThumbnail) {
        this.imageThumbnail = imageThumbnail;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
