package pl.malek.service;

import org.springframework.stereotype.Service;
import pl.malek.dto.BikeDto;
import pl.malek.model.Bike;
import pl.malek.model.Category;
import pl.malek.repository.BikeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BikeService implements MethodInterface<BikeDto>{

    private final BikeRepository bikeRepository;

    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    @Override
    public List<BikeDto> getAll() {
        return null;
    }

    @Override
    public void add(BikeDto bikeDto) {
        Bike bike = new Bike();
        bike.setBikeName(bikeDto.getBikeName());
        bikeRepository.save(bike);
    }

    @Override
    public Optional<BikeDto> get(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(BikeDto bikeDto) {

    }
}
