package it.project.dinner.controller;

import it.project.dinner.dto.DinnerDTO;
import it.project.dinner.model.Dinner;
import it.project.dinner.service.DinnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/dinner")
@CrossOrigin(origins = {
        "http://localhost:3000",
        "https://dinners-fe.vercel.app/"
})
public class Controller {

    @Autowired
    DinnerService dinnerService;

    @GetMapping("/all")
    public List<DinnerDTO> getAllDinner() {

        log.info("Start method /all in the homepage");

        return dinnerService.getAllDinner();
    }

    @GetMapping("/next")
    public ResponseEntity<?> getNextDinner() {
        DinnerDTO next = dinnerService.getNextDinner();

        if (next == null) {
            return ResponseEntity.ok(Collections.emptyMap());
        }

        return ResponseEntity.ok(next);
    }




}
