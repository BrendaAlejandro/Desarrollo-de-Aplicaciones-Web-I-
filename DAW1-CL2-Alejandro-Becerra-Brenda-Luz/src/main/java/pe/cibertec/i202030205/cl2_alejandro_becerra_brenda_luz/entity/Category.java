package pe.cibertec.i202030205.cl2_alejandro_becerra_brenda_luz.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    private String name;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @OneToMany(mappedBy = "category")
    private List<FilmCategory> filmCategories;
}
