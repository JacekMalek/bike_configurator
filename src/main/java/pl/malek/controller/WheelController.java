package pl.malek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.malek.dto.WheelDto;
import pl.malek.service.WheelService;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/wheel")
public class WheelController {

public final WheelService wheelService;

    public WheelController(WheelService wheelService) {
        this.wheelService = wheelService;
    }

    @GetMapping("/all")
    public String allWheels(Model model) {
        List<WheelDto> wheel = wheelService.getAll();
        model.addAttribute("wheel", wheel);
        return "all_wheels";
    }


    @GetMapping("/add")
    public String newWheel(Model model) {
        model.addAttribute("wheel", new WheelDto());
        return "new_wheel";
    }


    @PostMapping("/add")
    public String postWheel(@Valid WheelDto wheelDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new_wheel";
        }
        wheelService.add(wheelDto);
        return "redirect:/wheel/all";
    }

    @ModelAttribute("size")
    public List<String> sizes() {
        return List.of("26", "27,5", "29");
    }
 }
