package pe.cibertec.i202030205.cl2_alejandro_becerra_brenda_luz.repository;

import org.springframework.data.repository.CrudRepository;
import pe.cibertec.i202030205.cl2_alejandro_becerra_brenda_luz.entity.Inventory;
import jakarta.transaction.Transactional; // Para @Transactional
import org.springframework.data.jpa.repository.Modifying; // Para @Modifying
import org.springframework.data.jpa.repository.Query; // Para @Query
import org.springframework.data.repository.query.Param; // Para @Param

public interface InventoryRepository extends CrudRepository<Inventory, Integer> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Inventory i WHERE i.film.filmId = :filmId")
    void deleteByFilmId(@Param("filmId") int filmId);
}
