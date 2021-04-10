package pl.malek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.malek.model.Part;

@Repository
public interface PartRepository extends JpaRepository<Part, Long> {
}
