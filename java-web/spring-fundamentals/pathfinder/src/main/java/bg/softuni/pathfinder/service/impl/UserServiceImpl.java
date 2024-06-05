package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.model.UserEntity;
import bg.softuni.pathfinder.repository.UserRepository;
import bg.softuni.pathfinder.service.RouteService;
import bg.softuni.pathfinder.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean existByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public void registerUser(UserEntity user) {
        userRepository.save(user);
    }
}
