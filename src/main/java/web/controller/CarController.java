package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.service.UserService;
import web.service.UserServiceImp;

@Controller
public class CarController {
    @GetMapping(value = "/cars")
    public String cars(@RequestParam(defaultValue = "-1") Integer count, ModelMap model) {
        UserService userService = new UserServiceImp();
        model.addAttribute("cars", userService.getCarsByCount(count));
        return "cars";
    }

}
