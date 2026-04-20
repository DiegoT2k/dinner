package it.project.dinner.utils;

import it.project.dinner.dto.AttendanceDTO;
import it.project.dinner.dto.DessertDTO;
import it.project.dinner.dto.DinnerDTO;
import it.project.dinner.model.Dinner;

import java.util.List;

public class DinnerUtils {

    public static DinnerDTO convertDinnerToDinnerDTO(Dinner dinner) {

        DinnerDTO dto = new DinnerDTO();
        dto.setId(dinner.getId());
        dto.setDate(dinner.getDate());
        dto.setName(dinner.getName());

        // Dessert
        if (dinner.getDessert() != null) {
            DessertDTO dessertDTO = new DessertDTO(
                    dinner.getDessert().getId(),
                    dinner.getDessert().getName(),
                    dinner.getDessert().getMadeBy()
            );
            dto.setDessert(dessertDTO);
        }

        // Attendance
        if (dinner.getAttendees() != null) {
            List<AttendanceDTO> attendees = dinner.getAttendees().stream()
                    .map(a -> new AttendanceDTO(
                            a.getId(),
                            a.getUser().getId(),
                            a.getUser().getName(),
                            a.getUser().getSurname()
                    ))
                    .toList();

            dto.setAttendees(attendees);
        }

        return dto;
    }

}
