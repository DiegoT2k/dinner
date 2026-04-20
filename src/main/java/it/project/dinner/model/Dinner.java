package it.project.dinner.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "DINNER")
public class Dinner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DATE_EVENT")
    private Timestamp date;

    @Column(name = "NAME")
    private String name;

    @OneToOne(mappedBy = "dinner", cascade = CascadeType.ALL)
    private Dessert dessert;

    @OneToMany(mappedBy = "dinner", cascade = CascadeType.ALL)
    private List<DinnerAttendance> attendees = new ArrayList<>();

}
