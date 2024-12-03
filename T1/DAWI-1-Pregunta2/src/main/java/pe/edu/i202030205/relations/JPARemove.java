package pe.edu.i202030205.relations;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202030205.entity.Country;

public class JPARemove {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("worldPU");
        EntityManager em = emf.createEntityManager();

        // Encontrar el país imaginario
        em.getTransaction().begin();
        Country country = em.find(Country.class, "Canada");

        if (country != null) {
            em.remove(country);
        } else {
            System.out.println("País no encontrado.");
        }
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
