package pl.malek.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.malek.calculator.PriceCalculator;
import pl.malek.calculator.WeightCalculator;
import pl.malek.dto.BikeDto;
import pl.malek.model.Bike;
import pl.malek.repository.BikeRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BikeService implements MethodInterface<BikeDto> {

    private final BikeRepository bikeRepository;

    private static final Logger log = LoggerFactory.getLogger(BikeService.class);

    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }


    @Override
    public List<BikeDto> getAll() {
        return bikeRepository.findAll()
                .stream()
                .map(bike -> new BikeDto(bike.getId(), bike.getName(), bike.getFrame(),
                        bike.getWheel(), bike.getBrake(), bike.getWeight(), bike.getPrice()))
                .collect(Collectors.toList());
    }


    @Override
    public void add(BikeDto bikeDto) {
        Bike bike = new Bike();
        PriceCalculator priceCalculator = new PriceCalculator();
        WeightCalculator weightCalculator = new WeightCalculator();
        bike.setName(bikeDto.getName());
        bike.setFrame(bikeDto.getFrame());
        bike.setWheel(bikeDto.getWheel());
        bike.setBrake(bikeDto.getBrake());
        bike.setPrice(priceCalculator.calculatePrice(bikeDto.getFrame(), bikeDto.getWheel(), bikeDto.getBrake()));
        bike.setWeight(weightCalculator.calculateWeight(bikeDto.getFrame(), bikeDto.getWheel(), bikeDto.getBrake()));
        log.info("Dodano nowy rower");
        bikeRepository.save(bike);
    }


    @Override
    public Optional<BikeDto> get(Long id) {
        return bikeRepository.findById(id)
                .stream()
                .map(bike -> new BikeDto(bike.getId(), bike.getName(), bike.getFrame(),
                        bike.getWheel(), bike.getBrake(), bike.getWeight(), bike.getPrice()))
                .findFirst();
    }

    @Override
    public void delete(Long id) {
        bikeRepository.deleteById(id);
    }

    @Override
    public void update(BikeDto bikeDto) {
        Bike bike = new Bike();
        PriceCalculator priceCalculator = new PriceCalculator();
        WeightCalculator weightCalculator = new WeightCalculator();
        bike.setId(bikeDto.getId());
        bike.setName(bikeDto.getName());
        bike.setFrame(bikeDto.getFrame());
        bike.setWheel(bikeDto.getWheel());
        bike.setBrake(bikeDto.getBrake());
        bike.setPrice(priceCalculator.calculatePrice(bikeDto.getFrame(), bikeDto.getWheel(), bikeDto.getBrake()));
        bike.setWeight(weightCalculator.calculateWeight(bikeDto.getFrame(), bikeDto.getWheel(), bikeDto.getBrake()));
        log.info("Rower został zmieniony");
        bikeRepository.save(bike);
    }


    public Long bikeCount() {
        return bikeRepository.count();
    }

    public List <BikeDto> allBikeOrderByName(){
        return bikeRepository.findAll(Sort.by("name"))
                .stream()
                .map(bike -> new BikeDto(bike.getId(), bike.getName(), bike.getFrame(),
                        bike.getWheel(), bike.getBrake(), bike.getWeight(), bike.getPrice()))
                .collect(Collectors.toList());
    }


    public List <BikeDto> allBikeOrderByWeight(){
        return bikeRepository.findAll(Sort.by("weight").descending())
                               .stream()
                .map(bike -> new BikeDto(bike.getId(), bike.getName(), bike.getFrame(),
                        bike.getWheel(), bike.getBrake(), bike.getWeight(), bike.getPrice()))
                .collect(Collectors.toList());
    }

    public List <BikeDto> allBikeOrderByWeightAscending(){
        return bikeRepository.findAll(Sort.by("weight").ascending())
                .stream()
                .map(bike -> new BikeDto(bike.getId(), bike.getName(), bike.getFrame(),
                        bike.getWheel(), bike.getBrake(), bike.getWeight(), bike.getPrice()))
                .collect(Collectors.toList());
    }

    public List <BikeDto> allBikeOrderByPrice(){
        return bikeRepository.findAll(Sort.by("price").descending())
                .stream()
                .map(bike -> new BikeDto(bike.getId(), bike.getName(), bike.getFrame(),
                        bike.getWheel(), bike.getBrake(), bike.getWeight(), bike.getPrice()))
                .collect(Collectors.toList());
    }

    public List <BikeDto> allBikeOrderByPriceAscending(){
        return bikeRepository.findAll(Sort.by("price").ascending())
                .stream()
                .map(bike -> new BikeDto(bike.getId(), bike.getName(), bike.getFrame(),
                        bike.getWheel(), bike.getBrake(), bike.getWeight(), bike.getPrice()))
                .collect(Collectors.toList());
    }

}
