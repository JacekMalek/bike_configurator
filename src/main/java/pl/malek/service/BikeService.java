package pl.malek.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        bike.setName(bikeDto.getName());
        bike.setFrame(bikeDto.getFrame());
        bike.setWheel(bikeDto.getWheel());
        bike.setBrake(bikeDto.getBrake());
        bike.setPrice(PriceCalculator.calculatePrice(bikeDto.getFrame(), bikeDto.getWheel(), bikeDto.getBrake()));
        bike.setWeight(WeightCalculator.calculateWeight(bikeDto.getFrame(), bikeDto.getWheel(), bikeDto.getBrake()));
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
        bike.setId(bikeDto.getId());
        bike.setName(bikeDto.getName());
        bike.setFrame(bikeDto.getFrame());
        bike.setWheel(bikeDto.getWheel());
        bike.setBrake(bikeDto.getBrake());
        bike.setPrice(PriceCalculator.calculatePrice(bikeDto.getFrame(), bikeDto.getWheel(), bikeDto.getBrake()));
        bike.setWeight(WeightCalculator.calculateWeight(bikeDto.getFrame(), bikeDto.getWheel(), bikeDto.getBrake()));
        bikeRepository.save(bike);
    }

}
