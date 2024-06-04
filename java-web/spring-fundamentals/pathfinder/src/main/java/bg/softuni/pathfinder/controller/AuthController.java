package bg.softuni.pathfinder.controller;

import bg.softuni.pathfinder.dto.AuthResponseDto;
import bg.softuni.pathfinder.dto.UserLoginDto;
import bg.softuni.pathfinder.dto.UserRegisterDto;
import bg.softuni.pathfinder.mapper.UserMapper;
import bg.softuni.pathfinder.model.Role;
import bg.softuni.pathfinder.model.UserEntity;
import bg.softuni.pathfinder.model.enums.Level;
import bg.softuni.pathfinder.model.enums.UserRole;
import bg.softuni.pathfinder.repository.RoleRepository;
import bg.softuni.pathfinder.repository.UserRepository;
import bg.softuni.pathfinder.security.CustomUserDetailsService;
import bg.softuni.pathfinder.security.JwtGenerator;
import org.springframework.core.KotlinDetector;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.support.InvocableHandlerMethod;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;

@RestController
//@Controller
@RequestMapping("/users")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtGenerator jwtGenerator;
    private final UserMapper userMapper;
    private final CustomUserDetailsService customUserDetailsService;

    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, JwtGenerator jwtGenerator, UserMapper userMapper, CustomUserDetailsService customUserDetailsService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
        this.userMapper = userMapper;
        this.customUserDetailsService = customUserDetailsService;
    }

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("userLoginDto", new UserLoginDto());
        return "login";
    }

//    @PostMapping("/login")
//    public String login(UserLoginDto userLoginDto) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        userLoginDto.getUsername(),
//                        userLoginDto.getPassword()));
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String token = jwtGenerator.generateToken(authentication);
//
//        return "redirect:/home";
//    }

    @PostMapping("login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody UserLoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);

        AuthResponseDto authResponseDto = new AuthResponseDto();
        authResponseDto.setAccessToken(token);
        return new ResponseEntity<>(authResponseDto, HttpStatus.OK);
    }

    @GetMapping("/register")
    public String showRegistrationPage(Model model) {
        model.addAttribute("userRegisterDto", new UserRegisterDto());
        return "register";
    }

    @PostMapping("/register")
    public String register(UserRegisterDto userRegisterDto, Model model) {
        if (userRepository.existsByUsername(userRegisterDto.getUsername())) {
            model.addAttribute("error", "Username is taken!");
            return "redirect:register";
        }

        UserEntity user = userMapper.toUserEntity(userRegisterDto);
        user.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));

        Role roles = roleRepository.findByName(UserRole.USER).get();
        user.setRoles(Collections.singletonList(roles));

        user.setLevel(Level.BEGINNER);

        userRepository.save(user);

        model.addAttribute("success", "User registered successfully!");
        return "redirect:login";
    }
}
