package bg.softuni.softunigamestorefix.services;

import bg.softuni.softunigamestorefix.entities.User;

public interface ShoppingCartService {
    void addItem(User user, String gameTitle);
    void removeItem(User user, String gameTitle);
    void buyItems(User user);
}
