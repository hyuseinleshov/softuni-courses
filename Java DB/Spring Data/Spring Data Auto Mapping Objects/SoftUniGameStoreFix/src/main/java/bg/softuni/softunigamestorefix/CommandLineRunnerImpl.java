package bg.softuni.softunigamestorefix;

import bg.softuni.softunigamestorefix.entities.Game;
import bg.softuni.softunigamestorefix.entities.ShoppingCart;
import bg.softuni.softunigamestorefix.entities.User;
import bg.softuni.softunigamestorefix.services.GameService;
import bg.softuni.softunigamestorefix.services.ShoppingCartService;
import bg.softuni.softunigamestorefix.services.UserService;
import bg.softuni.softunigamestorefix.services.dtos.AddGameDTO;
import bg.softuni.softunigamestorefix.services.dtos.UserLoginDTO;
import bg.softuni.softunigamestorefix.services.dtos.UserRegisterDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final UserService userService;
    private final GameService gameService;
    private final ShoppingCartService cartService;

    public CommandLineRunnerImpl(UserService userService, GameService gameService, ShoppingCartService cartService) {
        this.userService = userService;
        this.gameService = gameService;
        this.cartService = cartService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String output = "";
        while (input != "END") {
            String[] tokens = input.split("\\|");
            String operation = tokens[0];

            switch (operation) {
                case "RegisterUser":
                    String email = tokens[1];
                    String password = tokens[2];
                    String confirmPassword = tokens[3];
                    String fullName = tokens[4];
                    output = this.userService.registerUser(new UserRegisterDTO(email, password, confirmPassword, fullName));
                    break;
                case "LoginUser":
                    String loginEmail = tokens[1];
                    String loginPassword = tokens[2];
                    output = this.userService.loginUser(new UserLoginDTO(loginEmail, loginPassword));
                    break;
                case "Logout":
                    output = this.userService.logoutUser();
                    break;
                case "AddGame":
                    String title = tokens[1];
                    Double price = Double.parseDouble(tokens[2]);
                    Double size = Double.parseDouble(tokens[3]);
                    String trailer = tokens[4];
                    String imageThumbnail = tokens[5];
                    String description = tokens[6];
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    LocalDate releaseDate = LocalDate.parse(tokens[7], formatter);
                    output = this.gameService.addGame(new AddGameDTO(title, price, size, trailer, imageThumbnail, description, releaseDate));
                    break;
                case "EditGame":
                    Long gameId = Long.parseLong(tokens[1]);
                    String[] editParams = Arrays.copyOfRange(tokens, 2, tokens.length);

                    Game gameToUpdate = gameService.findGameById(gameId);
                    if (gameToUpdate == null) {
                        output = "Game not found with ID: " + gameId;
                        break;
                    }

                    for (String param : editParams) {
                        String[] keyValue = param.split("=");
                        if (keyValue.length != 2) {
                            output = "Invalid parameter: " + param;
                            break;
                        }
                        String key = keyValue[0];
                        String value = keyValue[1];
                        switch (key) {
                            case "price":
                                gameToUpdate.setPrice(Double.parseDouble(value));
                                continue;
                            case "size":
                                gameToUpdate.setSize(Double.parseDouble(value));
                                continue;
                            case "title":
                                gameToUpdate.setTitle(value);
                                continue;
                            case "trailer":
                                gameToUpdate.setTrailer(value);
                                continue;
                            case "imageThumbnail":
                                gameToUpdate.setImageThumbnail(value);
                                continue;
                            case "description":
                                gameToUpdate.setDescription(value);
                                continue;
                            case "releaseDate":
                                LocalDate editReleaseDate = LocalDate.parse(value, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                                gameToUpdate.setReleaseDate(editReleaseDate);
                                continue;
                            default:
                                output = "Unsupported parameter: " + key;
                                break;
                        }
                        break;
                    }
                    gameService.updateGame(gameToUpdate);
                    output = "Game updated successfully";
                    break;
                case "DeleteGame":
                    Long id = Long.parseLong(tokens[1]);

                    Game gameToDelete = gameService.findGameById(id);
                    if (gameToDelete == null) {
                        output = "Game not found with ID: " + id;
                        break;
                    }

                    gameService.deleteById(id);
                    output = "Game deleted successfully";
                    break;
                case "AllGames":
                    List<Game> allGames = gameService.getAllGames();
                    allGames.forEach(g -> System.out.printf("%s %.2f\n", g.getTitle(), g.getPrice()));
                    break;
                case "DetailGame":
                    String titleToUse = tokens[1];

                    Game game = gameService.findGameByTitle(titleToUse);
                    if (game == null) {
                        output = "Game not found with title: " + titleToUse;
                        break;
                    }

                    System.out.println(game);
                    break;
                case "OwnedGames":
                    User user = userService.getLoggedIn();

                    if (user == null) {
                        output = "No user is logged in!";
                        break;
                    }

                    Set<Game> games = user.getGames();

                    if (games.isEmpty()) {
                        output = "No games for user " + user.getFullName();
                        break;
                    }

                    games.forEach(g -> System.out.println(g.getTitle()));
                    output = "";
                    break;
                case "PurchaseGame":
                    String gameTitle = tokens[1];
                    output = userService.purchaseGame(gameTitle);
                    break;
                case "AddItem":
                    User userAdd = userService.getLoggedIn();
                    if (userAdd == null) {
                        output = "No user is logged in!";
                        break;
                    }
                    String gameTitleToAdd = tokens[1];
                    cartService.addItem(userAdd, gameTitleToAdd);
                    output = gameTitleToAdd + " added to cart.";
                    break;
                case "RemoveItem":
                    User userRemove = userService.getLoggedIn();

                    if (userRemove == null) {
                        output = "No user is logged in!";
                        break;
                    }

                    String gameTitleToRemove = tokens[1];
                    cartService.removeItem(userRemove, gameTitleToRemove);
                    output = gameTitleToRemove + " removed from cart.";
                    break;
                case "BuyItem":
                    User userBuy = userService.getLoggedIn();

                    if (userBuy == null) {
                        output = "No user is logged in!";
                        break;
                    }

                    cartService.buyItems(userBuy);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Successfully bought games:").append(System.lineSeparator());
                    ShoppingCart shoppingCart = userBuy.getShoppingCart();
                    Set<Game> boughtGames = shoppingCart.getGames();
                    boughtGames.forEach(g -> sb.append("-").append(g.getTitle()).append(System.lineSeparator()));
                    break;
            }

            if (!(operation.equals("AllGames") || output.isEmpty())) {
                System.out.println(output);
            }

            input = scanner.nextLine();
        }
    }
}
