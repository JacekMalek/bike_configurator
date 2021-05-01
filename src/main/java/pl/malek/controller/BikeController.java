package pl.malek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.malek.dto.BikeDto;

import pl.malek.dto.BrakeDto;
import pl.malek.dto.FrameDto;
import pl.malek.dto.WheelDto;
import pl.malek.service.BikeService;
import pl.malek.service.BrakeService;
import pl.malek.service.FrameService;
import pl.malek.service.WheelService;

import javax.persistence.EntityExistsException;
import javax.validation.Valid;

import java.util.Collection;
import java.util.List;

// TODO: 23.04.2021 Sortowanie rowerów

@Controller
@RequestMapping("/bike")
public class BikeController {

    private final BikeService bikeService;
    private final FrameService frameService;
    private final WheelService wheelService;
    private final BrakeService brakeService;

    public BikeController(BikeService bikeService, FrameService frameService, WheelService wheelService, BrakeService brakeService) {
        this.bikeService = bikeService;
        this.frameService = frameService;
        this.wheelService = wheelService;
        this.brakeService = brakeService;
    }

    @GetMapping("/all")
    public String allBikes(Model model) {
        List<BikeDto> bikes = bikeService.getAll();
        model.addAttribute("bikes", bikes);
        return "all_bikes";
    }

    @GetMapping("/add")
    public String addNewBike(Model model) {
        model.addAttribute("bikeDto", new BikeDto());
        return "new_bike";
    }


    @PostMapping("/add")
    public String postAddBike(@ModelAttribute("bikeDto") @Valid BikeDto bikeDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new_bike";
        }
        bikeService.add(bikeDto);
        return "redirect:/bike/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteBike(@PathVariable Long id) {
        bikeService.delete(id);
        return "redirect:/bike/all";
    }


    @GetMapping("/edit/{id}")
    public String editBike(@PathVariable Long id, Model model) {
        model.addAttribute("bikeDto", bikeService.get(id));
        return "/edit_bike";
    }


    @PostMapping("/edit")
    public String postEditBike(@Valid BikeDto bikeDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit_bike";
        }
        bikeService.update(bikeDto);
        return "redirect:/bike/all";
    }


    @GetMapping("/details/{id}")
    public String getBikeById(@PathVariable Long id, Model model) {
        model.addAttribute("bike", bikeService.get(id).orElseThrow(EntityExistsException::new));
        return "bike_details";
    }


    @ModelAttribute("frames")
    public Collection<FrameDto> frames() {
        return frameService.getAll();
    }

    @ModelAttribute("wheels")
    public Collection<WheelDto> wheels() {
        return wheelService.getAll();
    }

    @ModelAttribute("brakes")
    public Collection<BrakeDto> brakes(){
        return brakeService.getAll();
    }
}
