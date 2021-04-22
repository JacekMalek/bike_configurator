package pl.malek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.malek.dto.CategoryDto;
import pl.malek.service.CategoryService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/all")
    public String allCategory(Model model){
        List<CategoryDto> category = categoryService.getAll();
        model.addAttribute("category", category);
        return "all_category";
    }


    @GetMapping("/add")
    public String newCategory(Model model){
        model.addAttribute("category", new CategoryDto());
        return "new_category";
    }


    @PostMapping("/add")
    public String postCategory(@Valid CategoryDto categoryDto, BindingResult bindingResult){
   if(bindingResult.hasErrors()){
       return "new_category";
   }
    categoryService.add(categoryDto);
    return "redirect:/category/all";
    }


    @GetMapping("/edit/{id}")
    public String editCategory(@PathVariable Long id, Model model){
        model.addAttribute("category", categoryService.get(id));
        return "edit_category";
    }


    @PutMapping("/edit")
    public String postEditCategory(@Valid CategoryDto categoryDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit_category";
        }
        categoryService.update(categoryDto);
        return "redirect:/category/all";
    }


    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable long id){
        categoryService.delete(id);
        return "redirect:/category/all";
    }
}
