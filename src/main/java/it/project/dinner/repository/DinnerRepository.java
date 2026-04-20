package it.project.dinner.repository;

import it.project.dinner.model.Dinner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface DinnerRepository extends JpaRepository<Dinner, Long> {

    Optional<Dinner> findFirstByDateAfterOrderByDateAsc(LocalDateTime date);


}
