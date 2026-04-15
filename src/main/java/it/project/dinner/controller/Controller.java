package it.project.dinner.controller;

import it.project.dinner.dto.DinnerDTO;
import it.project.dinner.service.DinnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/dinner")
@CrossOrigin(origins = {
        "http://localhost:3000",
        "https://dinners-fe.vercel.app/"
})
public class Controller {

    @Autowired
    DinnerService dinnerService;

    @GetMapping(path = "/all", produces = "application/json")
    public List<DinnerDTO> getAllDinner(){

        return dinnerService.getAllDinner();

    }

}
