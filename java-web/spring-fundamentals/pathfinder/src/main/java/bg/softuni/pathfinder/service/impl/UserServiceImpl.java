package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.dto.UserRegisterDto;
import bg.softuni.pathfinder.mapper.UserMapper;
import bg.softuni.pathfinder.model.Role;
import bg.softuni.pathfinder.model.UserEntity;
import bg.softuni.pathfinder.model.enums.Level;
import bg.softuni.pathfinder.model.enums.UserRole;
import bg.softuni.pathfinder.repository.UserRepository;
import bg.softuni.pathfinder.service.RoleService;
import bg.softuni.pathfinder.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder, RoleService roleService) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @Override
    public boolean existByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void registerUser(UserRegisterDto userRegisterDto) {
        UserEntity user = userMapper.toUserEntity(userRegisterDto);
        user.setPassword(passwordEncoder.encode((userRegisterDto.getPassword())));

        Role roles = roleService.findByName(UserRole.USER);
        user.setRoles(Collections.singletonList(roles));

        user.setLevel(Level.BEGINNER);

        userRepository.save(user);
    }
}
