package pl.malek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.malek.dto.BikeDto;
import pl.malek.model.Bike;

import java.util.List;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long> {


}
