package pl.malek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.malek.part.Part;
import pl.malek.service.PartService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/part")
public class PartController {
    private final PartService partService;

    public PartController(PartService partService) {
        this.partService = partService;
    }

    @GetMapping("/all")
    public String showParts(Model model) {
        List<Part> parts = partService.getAll();
        model.addAttribute("parts", parts);
        return "/all_parts";
    }

    @GetMapping("/add")
    public String addNewPart(Model model) {
        model.addAttribute("part", new Part());
        return "new_part";
    }

    @PostMapping("/add")
    public String postAddPart(@Valid Part part, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new_part";
        }
        partService.add(part);
        return "redirect:/part/all";
    }

    @GetMapping("/edit/{id}")
    public String editPart(@PathVariable Long id, Model model){
        model.addAttribute("part", partService.get(id));
        return "/edit_part";
    }

    @PostMapping("/edit")
    public String postEditPart(@Valid Part part, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "part";
        }
        partService.update(part);
        return "redirect:/part/edit";
    }

//
//    @ModelAttribute("parts")
//    public Collection<String> categories() {
//        return partService.getParts();
//    }




//    @ModelAttribute("categories")
//    public Collection<String> categories() {
//        return Set.of("Rama", "Korba", "Hamulce", "Pedały");
//    }

}
