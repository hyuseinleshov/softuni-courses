package bg.softuni.pathfinder.controller;

import bg.softuni.pathfinder.dto.UserLoginDto;
import bg.softuni.pathfinder.dto.UserRegisterDto;
import bg.softuni.pathfinder.mapper.UserMapper;
import bg.softuni.pathfinder.model.Role;
import bg.softuni.pathfinder.model.UserEntity;
import bg.softuni.pathfinder.model.enums.UserRole;
import bg.softuni.pathfinder.security.JwtGenerator;
import bg.softuni.pathfinder.service.RoleService;
import bg.softuni.pathfinder.service.UserService;
import jakarta.servlet.http.HttpSession;
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
    private final JwtGenerator jwtGenerator;

    public AuthController(AuthenticationManager authenticationManager, UserService userService, JwtGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtGenerator = jwtGenerator;
    }

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("userLoginDto", new UserLoginDto());
        return "login";
    }

    @PostMapping("/login")
    public String login(UserLoginDto userLoginDto, HttpSession session) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userLoginDto.getUsername(),
                            userLoginDto.getPassword()));

//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            String token = jwtGenerator.generateToken(authentication);

            String username = authentication.getName();
            UserEntity currentUser = userService.findByUsername(username);
            session.setAttribute("currentUser", currentUser);
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
    public String register(UserRegisterDto userRegisterDto) {
        if (userService.existByUsername(userRegisterDto.getUsername())) {
            return "register";
        }

        userService.registerUser(userRegisterDto);

        return "redirect:/users/login";
    }
}
