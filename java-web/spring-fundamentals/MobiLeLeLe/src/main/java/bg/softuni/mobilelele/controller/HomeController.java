package bg.softuni.mobilelele.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    /* @AuthenticationPrincipal User currentUser: Spring Security
    injects the currently authenticated user's details into
    the currentUser parameter. */
    // @AuthenticationPrincipal User currentUser

    @GetMapping("/")
    public String showIndexPage() {
        return "index";
    }
}
