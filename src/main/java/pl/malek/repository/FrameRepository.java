package pl.malek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.malek.model.Frame;

@Repository
public interface FrameRepository extends JpaRepository<Frame, Long>{

}