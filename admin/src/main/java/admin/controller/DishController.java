package admin.controller;

import admin.service.DishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class DishController {
    private DishService service;

    public DishController(DishService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public String allDishes(Model model) {
        model.addAttribute("dishes", service.getAllDishes());
        return "dishes";
    }
}
