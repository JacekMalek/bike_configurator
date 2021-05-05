package pl.malek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.malek.dto.BrakeDto;
import pl.malek.service.BrakeService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/brake")
public class BrakeController {

    public final BrakeService brakeService;

    public BrakeController(BrakeService brakeService) {
        this.brakeService = brakeService;
    }

    @GetMapping("/all")
    public String allBrake(Model model) {
        List<BrakeDto> brake = brakeService.getAll();
        model.addAttribute("brake", brake);
        return "all_brakes";
    }


    @GetMapping("/add")
    public String newBrake(Model model) {
        model.addAttribute("brakeDto", new BrakeDto());
        return "new_brake";
    }


    @PostMapping("/add")
    public String postBrake(@Valid BrakeDto brakeDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new_brake";
        }
        brakeService.add(brakeDto);
        return "redirect:/brake/all";
    }


    @GetMapping("/edit/{id}")
    public String editBrake(@PathVariable Long id, Model model){
        model.addAttribute("brakeDto", brakeService.get(id));
        return "/edit_brake";
    }

    @PostMapping("/edit")
    public String postEditBrake(@Valid BrakeDto brakeDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "edit_brake";
        }
        brakeService.update(brakeDto);
        return "redirect:/brake/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteBrake(@PathVariable Long id){
        brakeService.delete(id);
        return "redirect:/brake/all";
    }

    @ModelAttribute("type")
    public List<String> types() {
        return List.of("V-Brake", "Tarczowe-mechaniczne", "Tarczowe-hydrauliczne");
    }

    @ModelAttribute("producer")
    public List<String> producers(){
        return List.of("Shimano", "Sram", "Magura", "Tektro", "Xlc", "JagWire");
    }

}
