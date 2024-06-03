package bg.softuni.mobilelele.controller;

import bg.softuni.mobilelele.dto.LoginDto;
import bg.softuni.mobilelele.dto.RegisterDto;
import bg.softuni.mobilelele.mapper.UserMapper;
import bg.softuni.mobilelele.model.UserEntity;
import bg.softuni.mobilelele.model.UserRole;
import bg.softuni.mobilelele.model.enums.Role;
import bg.softuni.mobilelele.repository.UserRepository;
import bg.softuni.mobilelele.repository.UserRoleRepository;
import bg.softuni.mobilelele.security.JwtGenerator;
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
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtGenerator jwtGenerator;
    private final UserMapper userMapper;

    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder, JwtGenerator jwtGenerator, UserMapper userMapper) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
        this.userMapper = userMapper;
    }

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("loginDTO", new LoginDto());
        return "auth-login";
    }

    @PostMapping("/login")
    public String login(LoginDto loginDto, Model model) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDto.getUsername(),
                            loginDto.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtGenerator.generateToken(authentication);
            model.addAttribute("token", token);
            return "redirect:/";
        } catch (Exception e) {
            model.addAttribute("error", "Invalid username or password");
            return "auth-login";
        }
    }

    @GetMapping("/register")
    public String showRegistrationPage(Model model) {
        model.addAttribute("registerDto", new RegisterDto());
        model.addAttribute("roles", Role.values());
        return "auth-register";
    }

    @PostMapping("/register")
    public String register(RegisterDto registerDto, Model model) {
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            model.addAttribute("error", "Username is taken!");
            return "auth-register";
        }

        UserEntity user = userMapper.toUserEntity(registerDto);

        UserRole role = new UserRole(registerDto.getRole());
        user.setRole(role);

//        userRepository.save(user);

        model.addAttribute("success", "User registered successfully!");
        return "redirect:/";
    }
}

