package pe.edu.i202030205.cl1_jpa_data_alejandro_brenda.entity;

import jakarta.persistence.*;
import lombok.Data;


import java.util.List;

@Data
@Entity
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "Code")
    private String code;

    private String name;
    private String continent;
    private String region;
    private Float surfaceArea;
    private Integer IndepYear;
    private Integer population;
    private Float lifeExpectancy;
    private Float gnp;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<City> cities;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<CountryLanguage> languages;
}
