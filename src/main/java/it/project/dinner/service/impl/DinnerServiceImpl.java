package it.project.dinner.service.impl;

import it.project.dinner.dto.DinnerDTO;
import it.project.dinner.model.Dinner;
import it.project.dinner.repository.DinnerRepository;
import it.project.dinner.service.DinnerService;
import it.project.dinner.utils.DinnerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DinnerServiceImpl implements DinnerService {

    @Autowired
    DinnerRepository dinnerRepository;

    @Override
    public List<DinnerDTO> getAllDinner() {

        List<Dinner> dinner = dinnerRepository.findAll();
        List<DinnerDTO> dinners = new ArrayList<>();

        for(Dinner d : dinner)
            dinners.add(DinnerUtils.convertDinnerToDinnerDTO(d));

        return dinners;
    }

    @Override
    public void insertDinner(DinnerDTO dinner) {

        Dinner d = new Dinner();
        d.setName(dinner.getName());
        d.setDate(dinner.getDate());

        dinnerRepository.save(d);
    }

}
