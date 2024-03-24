package bg.softuni.softunigamestorefix.services.dtos;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class AddGameDTO {
    @Pattern(regexp = "^[A-Z].*", message = "Title should begin with an uppercase letter")
    @Size(min = 3, max = 100, message = "Title length should be between 3 and 100 letters")
    private String title;
    @Positive(message = "Price must be a positive number")
    private Double price;
    @Positive(message = "Size must be a positive number")
    private Double size;
    @Size(min = 11, max = 11, message = "Invalid YouTube trailer URL")
    private String trailer;
    @Pattern(regexp = "^(http://|https://)[\\S]+$", message = "Invalid URL format")
    private String imageThumbnail;
    @Size(min = 20, message = "Description must be at least 20 characters long")
    private String description;
    private LocalDate releaseDate;

    public AddGameDTO(String title, Double price, Double size, String trailer, String imageThumbnail, String description, LocalDate releaseDate) {
        this.title = title;
        this.price = price;
        this.size = size;
        this.trailer = trailer;
        this.imageThumbnail = imageThumbnail;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
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
