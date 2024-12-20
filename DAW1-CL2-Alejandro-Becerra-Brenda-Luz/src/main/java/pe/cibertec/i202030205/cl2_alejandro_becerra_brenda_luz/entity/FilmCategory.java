package pe.cibertec.i202030205.cl2_alejandro_becerra_brenda_luz.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmCategory {

    @EmbeddedId
    private FilmCategoryId id;

    @ManyToOne
    @MapsId("filmId")
    @JoinColumn(name = "film_id", nullable = false)
    private Film film;

    @ManyToOne
    @MapsId("categoryId")
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
}

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
class FilmCategoryId {
    private Integer filmId;
    private Integer categoryId;
}
