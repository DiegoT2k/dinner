package it.project.dinner.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceDTO {

    private Long id;
    private Long userId;
    private String userName;
    private String userSurname;
}
