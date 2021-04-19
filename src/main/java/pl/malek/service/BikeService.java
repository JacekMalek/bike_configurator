package pl.malek.service;

import org.springframework.stereotype.Service;
import pl.malek.dto.BikeDto;

import java.util.List;
import java.util.Optional;

@Service
public class BikeService implements MethodInterface<BikeDto>{
    @Override
    public List<BikeDto> getAll() {
        return null;
    }

    @Override
    public void add(BikeDto bikeDto) {

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
