package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.repository.UserRepository;
import bg.softuni.pathfinder.service.RouteService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements RouteService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
