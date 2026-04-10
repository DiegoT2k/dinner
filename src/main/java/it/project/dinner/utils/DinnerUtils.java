package it.project.dinner.utils;

import it.project.dinner.dto.DinnerDTO;
import it.project.dinner.model.Dinner;

public class DinnerUtils {

    public static final DinnerDTO convertDinnerToDinnerDTO(Dinner dinner){

        return new DinnerDTO(dinner.getDate(), dinner.getName());

    }
}
