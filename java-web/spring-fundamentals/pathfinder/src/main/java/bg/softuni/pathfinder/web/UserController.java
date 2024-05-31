package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.service.dto.UserLoginDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("userLoginDTO", new UserLoginDTO());
        return "login";
    }

    @PostMapping("/login")
    public String login(UserLoginDTO userLoginDTO) {
        return "redirect:/";
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }
}
