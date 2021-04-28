package pl.malek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/all_parts")
public class AllPartController {

    @RequestMapping("/")
    public String AllParts(){
        return "all_parts";
    }
}

