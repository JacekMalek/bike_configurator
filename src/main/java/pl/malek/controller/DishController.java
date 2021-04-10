package pl.malek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/dish")
public class DishController {

    @GetMapping("/all")
    public String getAllDishes() {
        return "first";
    }

    @GetMapping
    @ResponseBody
    public String getAllDishes1() {
        return "Rolada, Żurek, Modra Kaupsta";
    }
}