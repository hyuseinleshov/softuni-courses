package bg.softuni.softunigamestorefix.services.impl;

import bg.softuni.softunigamestorefix.entities.Game;
import bg.softuni.softunigamestorefix.entities.ShoppingCart;
import bg.softuni.softunigamestorefix.entities.User;
import bg.softuni.softunigamestorefix.repositories.ShoppingCartRepository;
import bg.softuni.softunigamestorefix.repositories.UserRepository;
import bg.softuni.softunigamestorefix.services.GameService;
import bg.softuni.softunigamestorefix.services.ShoppingCartService;
import bg.softuni.softunigamestorefix.services.UserService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository cartRepository;
    private final UserService userService;
    private final UserRepository userRepository;
    private final GameService gameService;

    public ShoppingCartServiceImpl(ShoppingCartRepository cartRepository, UserService userService, UserRepository userRepository, GameService gameService) {
        this.cartRepository = cartRepository;
        this.userService = userService;
        this.userRepository = userRepository;
        this.gameService = gameService;
    }


    @Override
    public void addItem(User user, String gameTitle) {
        Game game = gameService.findGameByTitle(gameTitle);
        if (game != null) {
            if (user != null) {
                ShoppingCart cart = user.getShoppingCart();
                if (cart == null) {
                    cart = new ShoppingCart();
                    user.setShoppingCart(cart); // Associate the cart with the user
                }
                cart.getGames().add(game);
                userRepository.save(user); // Save the updated user (and its associated cart)
                System.out.println("Game added to cart: " + title);
            } else {
                System.out.println("User not found with ID: " + userId);
            }
        } else {
            System.out.println("Game not found: " + title);
        }
    }

    @Override
    public void removeItem(User user, String gameTitle) {
        ShoppingCart cart = user.getShoppingCart();
        if (cart == null) {
            cart = new ShoppingCart();
        }
        Game game = gameService.findGameByTitle(gameTitle);

        if (game != null && cart.getGames().contains(game)) {
            cart.getGames().remove(game);
            cartRepository.save(cart);
        }
    }

    @Override
    public void buyItems(User user) {
        ShoppingCart cart = user.getShoppingCart();
        if (cart == null) {
            cart = new ShoppingCart();
        }
        Set<Game> gamesToBuy = cart.getGames();

        user.getGames().addAll(gamesToBuy);
        cart.getGames().clear();

        userRepository.saveAndFlush(user);
        cartRepository.save(cart);
    }
}
