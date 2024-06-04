package bg.softuni.pathfinder.controller;

import bg.softuni.pathfinder.model.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String showIndexPage(UserEntity currentUser, Model model) {
        return "index";
    }

    @GetMapping("/home")
    public String showHomePage() {
        return "home";
    }
}
