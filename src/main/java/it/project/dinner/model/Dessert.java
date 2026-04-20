package it.project.dinner.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "DESSERT")
public class Dessert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "MADE_BY", nullable = false)
    private String madeBy;

    @OneToOne
    @JoinColumn(name = "DINNER_ID", referencedColumnName = "ID")
    private Dinner dinner;

}
