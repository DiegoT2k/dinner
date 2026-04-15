package it.project.dinner.service;

import it.project.dinner.dto.DinnerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DinnerService {

    List<DinnerDTO> getAllDinner();

    void insertDinner(DinnerDTO dinner);

    void deleteDinner(Long id);

    void updateDinner(DinnerDTO dinner, Long id);

}
