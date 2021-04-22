package pl.malek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
        model.addAttribute("wheelDto", new WheelDto());
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

    @GetMapping("/edit/{id}")
    public String editWheel(@PathVariable Long id, Model model){
        model.addAttribute("wheel", wheelService.get(id));
        return "/edit_wheel";
    }

    @PostMapping("/edit")
    public String postEditWheel(@Valid WheelDto wheelDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "edit_wheel";
        }
        wheelService.update(wheelDto);
        return "redirect:/wheel/all";
    }


    @GetMapping("/delete/{id}")
    public String deleteWheel(@PathVariable long id){
        wheelService.delete(id);
        return "redirect:/wheel/all";
    }

    @ModelAttribute("size")
    public List<String> sizes() {
        return List.of("26", "27,5", "29");
    }
 }
