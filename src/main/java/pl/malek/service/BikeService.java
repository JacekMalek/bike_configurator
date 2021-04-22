package pl.malek.service;

import org.springframework.stereotype.Service;
import pl.malek.dto.BikeDto;
import pl.malek.model.Bike;

import pl.malek.repository.BikeRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BikeService implements MethodInterface<BikeDto>{

    private final BikeRepository bikeRepository;

    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    BigDecimal price = new BigDecimal("500");


    @Override
    public List<BikeDto> getAll() {
        return bikeRepository.findAll()
                .stream()
                .map(bike -> new BikeDto(bike.getId(), bike.getName(), bike.getWeight(), bike.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public void add(BikeDto bikeDto) {
        Bike bike = new Bike();
        bike.setName(bikeDto.getName());
        bike.setFrame(bikeDto.getFrame());
        bike.setWheel(bikeDto.getWheel());
        bike.setPrice(price);
        bike.setWeight(5.00);
        bikeRepository.save(bike);
    }

    @Override
    public Optional<BikeDto> get(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        bikeRepository.deleteById(id);
    }

    @Override
    public void update(BikeDto bikeDto) {

    }
}
