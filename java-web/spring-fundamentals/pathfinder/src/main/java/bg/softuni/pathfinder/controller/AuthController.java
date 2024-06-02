package bg.softuni.pathfinder.controller;

import bg.softuni.pathfinder.dto.LoginDto;
import bg.softuni.pathfinder.dto.RegisterDto;
import bg.softuni.pathfinder.model.Role;
import bg.softuni.pathfinder.model.UserModel;
import bg.softuni.pathfinder.model.enums.UserRole;
import bg.softuni.pathfinder.repository.RoleRepository;
import bg.softuni.pathfinder.repository.UserRepository;
import bg.softuni.pathfinder.security.JwtGenerator;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Controller
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtGenerator jwtGenerator;

    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, JwtGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("userLoginDTO", new LoginDto());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("userLoginDTO") LoginDto loginDto, Model model) {
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
            return "login";
        }
    }

    @GetMapping("/register")
    public String showRegistrationPage(Model model) {
        model.addAttribute("registerDto", new RegisterDto());
        return "register";
    }

    @PostMapping("/register")
    public String register(RegisterDto registerDto, Model model) {
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            model.addAttribute("error", "Username is taken!");
            return "register";
        }

        UserModel user = new UserModel();
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Role roles = roleRepository.findByName(UserRole.USER).orElse(null);
        user.setRoles(Collections.singletonList(roles));

        userRepository.save(user);

        model.addAttribute("success", "User registered successfully!");
        return "redirect:/login";
    }
}
