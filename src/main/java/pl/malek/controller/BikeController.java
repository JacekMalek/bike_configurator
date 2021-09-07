package pl.malek.controller;

import com.lowagie.text.DocumentException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.malek.dto.BikeDto;
import pl.malek.dto.BrakeDto;
import pl.malek.dto.FrameDto;
import pl.malek.dto.WheelDto;
import pl.malek.pdf.PdfCreator;
import pl.malek.pdf.PdfCreatorSelectedBike;
import pl.malek.service.BikeService;
import pl.malek.service.BrakeService;
import pl.malek.service.FrameService;
import pl.malek.service.WheelService;
import javax.persistence.EntityExistsException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
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

    @GetMapping("/")
    public String allBikes(Model model) {
        List<BikeDto> bikes = bikeService.getAll();
        model.addAttribute("bikes", bikes);
        return "index";
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
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteBike(@PathVariable Long id) {
        bikeService.delete(id);
        return "redirect:/";
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
        return "redirect:/";
    }


    @GetMapping("/details/{id}")
    public String getBikeById(@PathVariable Long id, Model model) {
        model.addAttribute("bike", bikeService.get(id).orElseThrow(EntityExistsException::new));
        return "bike_details";
    }

    @GetMapping("/allByName")
    public String getAllBikesByName(Model model) {
        List<BikeDto> bikes = bikeService.allBikeOrderByName();
        model.addAttribute("bikes", bikes);
        return "index";
    }

    @GetMapping("/allByWeight")
    public String getAllBikesByWeight(Model model) {
        List<BikeDto> bikes = bikeService.allBikeOrderByWeight();
        model.addAttribute("bikes", bikes);
        return "index";
    }

    @GetMapping("/allByWeightAscending")
    public String getAllBikesByWeightAscending(Model model) {
        List<BikeDto> bikes = bikeService.allBikeOrderByWeightAscending();
        model.addAttribute("bikes", bikes);
        return "index";
    }

    @GetMapping("/allByPrice")
    public String getAllBikesByPrice(Model model) {
        List<BikeDto> bikes = bikeService.allBikeOrderByPrice();
        model.addAttribute("bikes", bikes);
        return "index";
    }

    @GetMapping("/allByPriceAscending")
    public String getAllBikesByPriceAscending(Model model) {
        List<BikeDto> bikes = bikeService.allBikeOrderByPriceAscending();
        model.addAttribute("bikes", bikes);
        return "index";
    }

    @GetMapping("/pdfRaport")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        dateAndTimeForPdf(response);

        List<BikeDto> bikeList = bikeService.allBikeOrderByName();
        PdfCreator exporter = new PdfCreator(bikeList, bikeService);
        exporter.export(response);
    }

    @GetMapping("/pdfRaportSelectedBike/{id}")
    public void exportToPdfSelectedBike(@PathVariable Long id, HttpServletResponse response) throws DocumentException, IOException {
        dateAndTimeForPdf(response);

        BikeDto selectedBike = bikeService.get(id).orElseThrow(EntityExistsException::new);
        PdfCreatorSelectedBike exporter = new PdfCreatorSelectedBike(selectedBike);
        exporter.export(response);
    }

    private void dateAndTimeForPdf(HttpServletResponse response) {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=bike_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
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
    public Collection<BrakeDto> brakes() {
        return brakeService.getAll();
    }

    @ModelAttribute("count")
    public Long count() {
        return bikeService.bikeCount();
    }
}
