package pl.malek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.malek.dto.CategoryDto;
import pl.malek.dto.PartDto;
import pl.malek.model.Part;
import pl.malek.service.CategoryService;
import pl.malek.service.PartService;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/part")
public class PartController {
    private final PartService partService;
    private final CategoryService categoryService;

    public PartController(PartService partService, CategoryService categoryService) {
        this.partService = partService;
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public String showParts(Model model) {
        List<PartDto> parts = partService.getAll();
        model.addAttribute("parts", parts);
        return "/all_parts";
    }

    @GetMapping("/add")
    public String addNewPart(Model model) {
        model.addAttribute("part", new Part());
        return "new_part";
    }

    @PostMapping("/add")
    public String postAddPart(@Valid PartDto partDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new_part";
        }
        partService.add(partDto);
        return "redirect:/part/all";
    }

    @GetMapping("/edit/{id}")
    public String editPart(@PathVariable Long id, Model model){
        model.addAttribute("part", partService.get(id));
        return "/edit_part";
    }

    @PostMapping("/edit")
    public String postEditPart(@Valid PartDto partDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "part";
        }
        partService.update(partDto);
        return "redirect:/part/edit";
    }


    @ModelAttribute("categories")
    public Collection<CategoryDto> categories() {
        return categoryService.getAll();
    }
}
