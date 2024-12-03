package pe.edu.i202030205.cl1_jpa_data_alejandro_brenda.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.i202030205.cl1_jpa_data_alejandro_brenda.entity.Country;

public interface CountryRepository extends JpaRepository<Country, String> {
}
