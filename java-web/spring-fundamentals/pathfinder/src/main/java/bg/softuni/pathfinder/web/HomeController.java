package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    /* @AuthenticationPrincipal User currentUser: Spring Security
    injects the currently authenticated user's details into
    the currentUser parameter. */
    // @AuthenticationPrincipal User currentUser
    @GetMapping("/")
    public String showIndexPage() {
//        model.addAttribute("currentUser", currentUser);
        return "index";
    }
}
