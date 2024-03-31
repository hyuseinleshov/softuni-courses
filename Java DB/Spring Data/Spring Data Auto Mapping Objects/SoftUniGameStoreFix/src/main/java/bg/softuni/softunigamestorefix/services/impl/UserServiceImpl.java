package bg.softuni.softunigamestorefix.services.impl;

import bg.softuni.softunigamestorefix.entities.Game;
import bg.softuni.softunigamestorefix.entities.User;
import bg.softuni.softunigamestorefix.repositories.GameRepository;
import bg.softuni.softunigamestorefix.repositories.UserRepository;
import bg.softuni.softunigamestorefix.services.UserService;
import bg.softuni.softunigamestorefix.services.dtos.UserLoginDTO;
import bg.softuni.softunigamestorefix.services.dtos.UserRegisterDTO;
import bg.softuni.softunigamestorefix.services.util.ValidationService;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private User loggedIn;
    private final UserRepository userRepository;
    private final GameRepository gameRepository;
    private final ValidationService validationService;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, GameRepository gameRepository, ValidationService validationService, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
        this.validationService = validationService;
        this.modelMapper = modelMapper;
    }

    @Override
    public String registerUser(UserRegisterDTO userRegisterDTO) {
        if (!this.validationService.isValid(userRegisterDTO)) {
            Set<ConstraintViolation<UserRegisterDTO>> set = this.validationService.validate(userRegisterDTO);
            return set.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining("\n"));
        }

        if (!userRegisterDTO.getPassword().equals(userRegisterDTO.getConfirmPassword())) {
            return "Passwords don't match.";
        }

        Optional<User> optional = this.userRepository.findUserByEmail(userRegisterDTO.getEmail());
        if (optional.isPresent()) {
            return "User with that email already exists.";
        }

        User user = this.modelMapper.map(userRegisterDTO, User.class);

        if (this.userRepository.count() == 0) {
            user.setAdmin(true);
        }

        this.userRepository.saveAndFlush(user);

        return String.format("%s was registered.", user.getFullName());
    }

    @Override
    public String loginUser(UserLoginDTO userLoginDTO) {
        Optional<User> optional = this.userRepository.findByEmailAndPassword(userLoginDTO.getEmail(), userLoginDTO.getPassword());
        if (optional.isEmpty()) {
            return "Incorrect username / password";
        }

        setLoggedIn(optional.get());
        return String.format("Successfully logged in %s", loggedIn.getFullName());
    }

    @Override
    public String logoutUser() {
        if (this.loggedIn == null) {
            return "Cannot log out. No user was logged in.";
        }

        String fullName = this.loggedIn.getFullName();
        setLoggedIn(null);
        return String.format("User %s successfully logged out", fullName);
    }

    @Override
    public String purchaseGame(String title) {
        if (loggedIn == null) {
            return "No user is logged in!";
        }

        Game game = this.gameRepository.findGameByTitle(title);

        if (game == null) {
            return "Game not found!";
        }

        loggedIn.getGames().add(game);
        return String.format("%s is purchased successfully for user %s", game.getTitle(), loggedIn.getFullName());
    }

    @Override
    public User getLoggedIn() {
        return this.loggedIn;
    }

    private void setLoggedIn(User loggedIn) {
        this.loggedIn = loggedIn;
    }
}
