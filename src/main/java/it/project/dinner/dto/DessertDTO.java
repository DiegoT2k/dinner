package it.project.dinner.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DessertDTO {
    private Long id;
    private String name;
    private String madeBy;
}

