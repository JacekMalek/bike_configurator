package pl.malek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/new_part")
public class PartController {

    @RequestMapping("/")
    public String NewPartr(){
        return "new_part";
    }
}
