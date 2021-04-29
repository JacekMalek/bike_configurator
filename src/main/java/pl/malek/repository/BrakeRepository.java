package pl.malek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.malek.model.Brake;

@Repository
public interface BrakeRepository extends JpaRepository<Brake, Long> {
}
