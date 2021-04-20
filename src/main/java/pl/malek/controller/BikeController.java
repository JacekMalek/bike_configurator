package pl.malek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.malek.dto.BikeDto;
import pl.malek.model.Bike;
import pl.malek.service.BikeService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/bike")
public class BikeController {
    private final BikeService bikeService;

    public BikeController(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    @GetMapping("/all")
    public String allCategory(Model model){
        List<BikeDto> bikes = bikeService.getAll();
        model.addAttribute("bike", bikes);
        return "all_bikes";
    }

    @GetMapping("/add")
    public String addNewBike(Model model) {
        model.addAttribute("bike", new Bike());
        return "new_bike";
    }

    @PostMapping("/add")
    public String postAddBike(@Valid BikeDto bikeDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new_bike";
        }
        bikeService.add(bikeDto);
        return "redirect:/bike/all";
    }

}
