package pl.malek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.malek.model.Wheel;

public interface WheelRepository extends JpaRepository<Wheel, Long> {
}
