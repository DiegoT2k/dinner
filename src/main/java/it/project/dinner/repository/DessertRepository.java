package it.project.dinner.repository;

import it.project.dinner.model.Dessert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DessertRepository extends JpaRepository<Dessert, Long> {
    Optional<Dessert> findByDinnerId(Long dinnerId);
}

