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
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer inventoryId;

    @ManyToOne
    @JoinColumn(name = "film_id", nullable = false)
    private Film film;

    private Integer storeId;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
}
