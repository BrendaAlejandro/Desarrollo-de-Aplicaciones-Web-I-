package pe.edu.i202030205.relations;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202030205.entity.City;
import pe.edu.i202030205.entity.Country;

public class JPAFind {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("worldPU");
        EntityManager em = emf.createEntityManager();
        // Buscar el país
        Country peru = em.find(Country.class, "PER");
        if (peru != null) {
            // Filtrar ciudades > 700,000
            peru.getCities().stream()
                    .filter(city -> city.getPopulation() > 700000)
                    .forEach(city -> System.out.println("Ciudad: " + city.getName() + ", Población: " + city.getPopulation()));
        } else {
            System.out.println("El país con código 'PER' no fue encontrado.");
        }
        em.close();
        emf.close();
    }
}
