package pe.edu.i202030205.cl1_jpa_data_alejandro_brenda.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "countrylanguage")
public class CountryLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CountryCode")
    private Country country;

    private String language;
    private String isOfficial;
    private Float percentage;
}