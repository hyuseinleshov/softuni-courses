package bg.softuni.pathfinder.controller;

import bg.softuni.pathfinder.dto.UserLoginDto;
import bg.softuni.pathfinder.dto.UserRegisterDto;
import bg.softuni.pathfinder.mapper.UserMapper;
import bg.softuni.pathfinder.model.Role;
import bg.softuni.pathfinder.model.UserEntity;
import bg.softuni.pathfinder.model.enums.UserRole;
import bg.softuni.pathfinder.repository.RoleRepository;
import bg.softuni.pathfinder.security.JwtGenerator;
import bg.softuni.pathfinder.service.RoleService;
import bg.softuni.pathfinder.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Controller
@RequestMapping("/users")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
    private final JwtGenerator jwtGenerator;
    private final UserMapper userMapper;

    public AuthController(AuthenticationManager authenticationManager, UserService userService, RoleService roleService, PasswordEncoder passwordEncoder, JwtGenerator jwtGenerator, UserMapper userMapper) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
        this.userMapper = userMapper;
    }

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("userLoginDto", new UserLoginDto());
        return "login";
    }

    @PostMapping("/login")
    public String login(UserLoginDto userLoginDto) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userLoginDto.getUsername(),
                            userLoginDto.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtGenerator.generateToken(authentication);
        } catch (Exception e) {
            return "login";
        }

        return "redirect:/home";
    }

    @GetMapping("/register")
    public String showRegistrationPage(Model model) {
        model.addAttribute("userRegisterDto", new UserRegisterDto());
        return "register";
    }

    @PostMapping("/register")
    public String register(UserRegisterDto userRegisterDto, Model model) {
        if (userService.existByUsername(userRegisterDto.getUsername())) {
            return "register";
        }

        UserEntity user = userMapper.toUserEntity(userRegisterDto);
        user.setPassword(passwordEncoder.encode((userRegisterDto.getPassword())));

        Role roles = roleService.findByName(UserRole.USER);
        user.setRoles(Collections.singletonList(roles));

        userService.registerUser(user);

        return "redirect:/login";
    }
}
