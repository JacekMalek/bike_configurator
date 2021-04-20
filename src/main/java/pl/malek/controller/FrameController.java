package pl.malek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.malek.dto.FrameDto;
import pl.malek.service.FrameService;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Set;

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
        model.addAttribute("frame", new FrameDto());
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

    @ModelAttribute("size")
    public List<String> sizes() {
        return List.of("S - small", "M - medium", "L - large", "XL - X - large");
    }

    @ModelAttribute("material")
    public List<String> material() {
        return List.of("Stal", "Aluminium", "Karbon");
    }

}