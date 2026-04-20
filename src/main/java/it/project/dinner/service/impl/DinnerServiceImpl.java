package it.project.dinner.service.impl;

import it.project.dinner.dto.DinnerDTO;
import it.project.dinner.model.Dinner;
import it.project.dinner.repository.DinnerRepository;
import it.project.dinner.service.DinnerService;
import it.project.dinner.utils.DinnerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DinnerServiceImpl implements DinnerService {

    @Autowired
    DinnerRepository dinnerRepository;

    public List<DinnerDTO> getAllDinner() {
        return dinnerRepository.findAll().stream()
                .map(DinnerUtils::convertDinnerToDinnerDTO)
                .toList();
    }

    public DinnerDTO getNextDinner() {
        Dinner next = dinnerRepository
                .findFirstByDateAfterOrderByDateAsc(LocalDateTime.now())
                .orElse(null);

        return next == null ? null : DinnerUtils.convertDinnerToDinnerDTO(next);
    }


    @Override
    public void insertDinner(DinnerDTO dinner) {

        Dinner d = new Dinner();
        d.setName(dinner.getName());
        d.setDate(dinner.getDate());

        dinnerRepository.save(d);
    }

    @Override
    public void deleteDinner(Long id) {

        dinnerRepository.deleteById(id);

    }

    @Override
    public void updateDinner(DinnerDTO dinner, Long id) {

        Optional<Dinner> d = dinnerRepository.findById(id);

        if(d.isPresent()){
            d.get().setName(dinner.getName());
            d.get().setDate(dinner.getDate());
            dinnerRepository.save(d.get());
        }

    }


}
