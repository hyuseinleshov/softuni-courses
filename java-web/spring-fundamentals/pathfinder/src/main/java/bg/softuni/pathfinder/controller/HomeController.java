package bg.softuni.pathfinder.controller;

import bg.softuni.pathfinder.model.UserEntity;
import bg.softuni.pathfinder.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {
    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showIndexPage(HttpSession session, Model model, Principal principal) {
        UserEntity currentUser = (UserEntity) session.getAttribute("currentUser");
        if (currentUser != null) {
//        if (principal != null) {
//            String username = principal.getName();
//            UserEntity currentUser = userService.findByUsername(username);

            model.addAttribute("currentUser", currentUser);

            System.out.println("Current user from session: " + currentUser.getUsername());
        }

        return "index";
    }

    @GetMapping("/home")
    public String showHomePage(HttpSession session, Model model) {
        UserEntity currentUser = (UserEntity) session.getAttribute("currentUser");
        if (currentUser != null) {
            model.addAttribute("currentUser", currentUser);

            System.out.println("Current user from session: " + currentUser.getUsername());
        }
        return "index";
    }
}
