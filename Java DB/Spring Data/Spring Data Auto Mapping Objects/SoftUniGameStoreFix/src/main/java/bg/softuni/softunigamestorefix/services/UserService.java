package bg.softuni.softunigamestorefix.services;

import bg.softuni.softunigamestorefix.entities.User;
import bg.softuni.softunigamestorefix.services.dtos.UserLoginDTO;
import bg.softuni.softunigamestorefix.services.dtos.UserRegisterDTO;

public interface UserService {

    String registerUser(UserRegisterDTO userRegisterDTO);

    String loginUser(UserLoginDTO userLoginDTO);

    String logoutUser();

    String purchaseGame(String title);

    User getLoggedIn();
}
