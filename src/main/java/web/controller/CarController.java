package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.service.UserService;

@Controller
public class CarController {

    private final UserService userService;

    public CarController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/cars")
    public String cars(@RequestParam(defaultValue = "5") Integer count, ModelMap model) {
        model.addAttribute("cars", userService.getCarsByCount(count));
        return "cars";
    }

}
