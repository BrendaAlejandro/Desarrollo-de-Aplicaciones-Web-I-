package pe.edu.i202030205.cl1_jpa_data_alejandro_brenda.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "CountryCode")
    private Country country;

    private String district;
    private Integer population;
}