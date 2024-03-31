package bg.softuni.softunigamestorefix.entities;

import bg.softuni.softunigamestorefix.services.ShoppingCartService;
import bg.softuni.softunigamestorefix.services.UserService;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.util.HashSet;
import java.util.Set;

@Entity
public class ShoppingCart extends BaseEntity {
    @ManyToOne
    private User user;

    @ManyToMany
    private Set<Game> games;

    public ShoppingCart() {
        user = new User();
        games = new HashSet<>();
    }

    public ShoppingCart(User user, Set<Game> games) {
        this.user = user;
        this.games = games;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}
