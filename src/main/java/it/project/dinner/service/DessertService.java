package it.project.dinner.service;

import it.project.dinner.dto.DessertDTO;
import it.project.dinner.dto.DinnerDTO;
import it.project.dinner.model.Dessert;
import it.project.dinner.model.Dinner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DessertService {

    public DessertDTO getDessertByDinner(Long dinnerId);

    public DessertDTO assignDessert(Long dinnerId, String name, String madeBy);
}
