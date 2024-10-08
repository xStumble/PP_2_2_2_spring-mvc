package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CarController {
    @GetMapping(value = "/cars")
    public String cars(@RequestParam(required = false) Integer count, ModelMap model) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Dodge", "Charger", 1969));
        cars.add(new Car("Porsche", "Panamera", 2012));
        cars.add(new Car("Ford", "Focus", 2013));
        cars.add(new Car("Audi", "R8", 2010));
        cars.add(new Car("Toyota", "Camry", 2008));

        if (count == null || count > cars.size()) {
            count = cars.size();
        }
        if (count < 0) {
            count = 0;
        }

        cars = cars.stream().limit(count).collect(Collectors.toList());

        model.addAttribute("cars", cars);
        return "cars";
    }

}
