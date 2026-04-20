package it.project.dinner.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "DINNER_ATTENDANCE")
public class DinnerAttendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DINNER_ID")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Dinner dinner;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user;

}

