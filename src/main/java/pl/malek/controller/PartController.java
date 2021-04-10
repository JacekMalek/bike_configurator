package pl.malek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.malek.model.Part;
import pl.malek.repository.PartRepository;
import pl.malek.service.PartService;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/part")
public class PartController {
    private final PartService partService;

    public PartController(PartService partService) {
        this.partService = partService;
    }

    @GetMapping("/all")
    public String showParts(Model model) {
        List<Part> parts = partService.getParts();
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
        partService.addNewPart(part);
        return "redirect:/part/all";
    }

//    @ModelAttribute("categories")
//    public Collection<String> categories() {
//        return Set.of("Rama", "Korba", "Hamulce", "Pedały");
//    }

}
