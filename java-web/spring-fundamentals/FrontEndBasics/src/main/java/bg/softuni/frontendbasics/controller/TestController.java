package bg.softuni.frontendbasics.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TestController {

    @GetMapping("/api/data")
    public String getData() {
        return "This is some data from the backend!";
    }

    @GetMapping("/checkout")
    public ModelAndView myEndpoint() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("checkout"); // Name of your HTML view file without extension
        return modelAndView;
    }
}
