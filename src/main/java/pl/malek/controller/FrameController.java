package pl.malek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.malek.dto.FrameDto;
import pl.malek.service.FrameService;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/frame")
public class FrameController {
    public final FrameService frameService;

    public FrameController(FrameService frameService) {
        this.frameService = frameService;
    }


    @GetMapping("/all")
    public String allFrame(Model model) {
        List<FrameDto> frame = frameService.getAll();
        model.addAttribute("frame", frame);
        return "all_frame";
    }


    @GetMapping("/add")
    public String newFrame(Model model) {
        model.addAttribute("frameDto", new FrameDto());
        return "new_frame";
    }


    @PostMapping("/add")
    public String postFrame(@Valid FrameDto frameDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new_frame";
        }
        frameService.add(frameDto);
        return "redirect:/frame/all";
    }


    @GetMapping("/edit/{id}")
    public String editFrame(@PathVariable Long id, Model model){
        model.addAttribute("frame", frameService.get(id));
        return "/edit_frame";
    }

    @PostMapping("/edit")
    public String postEditFrame(@Valid FrameDto frameDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "edit_frame";
        }
        frameService.update(frameDto);
        return "redirect:/frame/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteFrame(@PathVariable Long id){
        frameService.delete(id);
        return "redirect:/frame/all";
    }

    @ModelAttribute("size")
    public List<String> sizes() {
        return List.of("S - small", "M - medium", "L - large", "XL - X - large");
    }

    @ModelAttribute("material")
    public List<String> material() {
        return List.of("Stal", "Aluminium", "Karbon");
    }

    @ModelAttribute("producer")
    public List<String> producer() {
        return List.of("Author", "Giant", "Romet", "KTM", "Mongoose", "GT", "Kross", "Merida", "Specialized");
    }

}