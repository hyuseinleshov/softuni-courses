package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.dto.UserRegisterDto;
import bg.softuni.pathfinder.model.UserEntity;

public interface UserService {
    boolean existByUsername(String username);

    UserEntity findByUsername(String username);

    void registerUser(UserRegisterDto userRegisterDto);
}
