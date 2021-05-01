package pl.malek.service;
import org.springframework.stereotype.Service;
import pl.malek.dto.BrakeDto;
import pl.malek.model.Brake;
import pl.malek.repository.BrakeRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BrakeService implements MethodInterface<BrakeDto>{

    private final BrakeRepository brakeRepository;

    public BrakeService(BrakeRepository brakeRepository) {
        this.brakeRepository = brakeRepository;
    }

    @Override
    public List <BrakeDto> getAll() {
        return brakeRepository.findAll()
    .stream()
    .map(brake -> new BrakeDto(brake.getId(), brake.getName(), brake.getType(),brake.getProducer(),
            brake.getPrice(), brake.getWeight()))
    .collect(Collectors.toList());

    }

   // TODO Dokończyć BrakeService

    @Override
    public void add(BrakeDto brakeDto) {
        Brake brake  = new Brake();
        brake.setName(brakeDto.getName());
        brake.setType(brakeDto.getType());
        brake.setProducer(brakeDto.getProducer());
        brake.setWeight(brakeDto.getWeight());
        brake.setPrice(brakeDto.getPrice());
        brakeRepository.save(brake);
    }

    @Override
    public Optional get(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(BrakeDto brakeDto) {

    }
}