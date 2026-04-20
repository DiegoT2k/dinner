package it.project.dinner.controller;

import it.project.dinner.dto.DessertDTO;
import it.project.dinner.model.Dessert;
import it.project.dinner.service.DessertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
@RestController
@RequestMapping("/dessert")
@CrossOrigin(origins = {
        "http://localhost:3000",
        "https://dinners-fe.vercel.app/"
})
public class DessertController {

    @Autowired
    private DessertService dessertService;

    @GetMapping("/byDinner/{dinnerId}")
    public ResponseEntity<?> getByDinner(@PathVariable Long dinnerId) {
        DessertDTO dto = dessertService.getDessertByDinner(dinnerId);
        return ResponseEntity.ok(dto == null ? Collections.emptyMap() : dto);
    }

    @PostMapping("/assign/{dinnerId}")
    public ResponseEntity<DessertDTO> assign(
            @PathVariable Long dinnerId,
            @RequestBody Map<String, String> body
    ) {
        return ResponseEntity.ok(
                dessertService.assignDessert(
                        dinnerId,
                        body.get("name"),
                        body.get("madeBy")
                )
        );
    }
}

