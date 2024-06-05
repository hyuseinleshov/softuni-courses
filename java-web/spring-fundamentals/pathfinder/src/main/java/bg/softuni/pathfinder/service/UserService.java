package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.UserEntity;

public interface UserService {
    boolean existByUsername(String username);

    void registerUser(UserEntity user);
}
