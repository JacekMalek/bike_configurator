package pl.malek.service;

import org.springframework.stereotype.Service;
import pl.malek.dto.WheelDto;

import pl.malek.model.Wheel;
import pl.malek.repository.WheelRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WheelService implements MethodInterface<WheelDto> {
    public final WheelRepository wheelRepository;

    public WheelService(WheelRepository wheelRepository) {
        this.wheelRepository = wheelRepository;
    }


    @Override
    public List<WheelDto> getAll() {
        return wheelRepository.findAll()
                .stream()
                .map(wheel -> new WheelDto(wheel.getId(), wheel.getName(),wheel.getSize(), wheel.getWeight(), wheel.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public void add(WheelDto wheelDto) {
        Wheel wheel = new Wheel();
        wheel.setName(wheelDto.getName());
        wheel.setSize(wheelDto.getSize());
        wheel.setWeight(wheelDto.getWeight());
        wheel.setPrice(wheelDto.getPrice());
        wheelRepository.save(wheel);
    }


    @Override
    public Optional<WheelDto> get(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        wheelRepository.deleteById(id);
    }

    @Override
    public void update(WheelDto wheelDto) {
        Wheel wheel = new Wheel();
        wheel.setId(wheelDto.getId());
        wheel.setName(wheelDto.getName());
        wheel.setSize(wheelDto.getSize());
        wheel.setWeight(wheelDto.getWeight());
        wheel.setPrice(wheelDto.getPrice());
        wheelRepository.save(wheel);
    }
}
