package it.project.dinner.service.impl;


import it.project.dinner.dto.DessertDTO;
import it.project.dinner.model.Dessert;
import it.project.dinner.model.Dinner;
import it.project.dinner.repository.DessertRepository;
import it.project.dinner.repository.DinnerRepository;
import it.project.dinner.service.DessertService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DessertServiceImpl implements DessertService {

    @Autowired
    private DessertRepository dessertRepository;

    @Autowired
    private DinnerRepository dinnerRepository;

    public DessertDTO getDessertByDinner(Long dinnerId) {
        return dessertRepository.findByDinnerId(dinnerId)
                .map(d -> {
                    DessertDTO dto = new DessertDTO();
                    dto.setId(d.getId());
                    dto.setName(d.getName());
                    dto.setMadeBy(d.getMadeBy());
                    return dto;
                })
                .orElse(null);
    }

    public DessertDTO assignDessert(Long dinnerId, String name, String madeBy) {
        log.info("START CREATIN DESSERT\n");
        Dinner dinner = dinnerRepository.findById(dinnerId)
                .orElseThrow(() -> new RuntimeException("Dinner not found"));

        Dessert dessert = dessertRepository.findByDinnerId(dinnerId)
                .orElse(new Dessert());

        dessert.setName(name);
        dessert.setMadeBy(madeBy);
        dessert.setDinner(dinner);

        Dessert saved = dessertRepository.save(dessert);

        log.info("DESSERT SAVED");

        DessertDTO dto = new DessertDTO();
        dto.setId(saved.getId());
        dto.setName(saved.getName());
        dto.setMadeBy(saved.getMadeBy());
        return dto;
    }
}

