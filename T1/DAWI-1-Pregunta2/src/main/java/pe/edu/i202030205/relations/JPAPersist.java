package pe.edu.i202030205.relations;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202030205.entity.Country;
import pe.edu.i202030205.entity.CountryLanguage;
import pe.edu.i202030205.entity.CountryLanguageId;

public class JPAPersist {
    public static void main(String[] args) {
        // Crear el EntityManagerFactory y EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("worldPU");
        EntityManager em = emf.createEntityManager();

        try {
            // Iniciar transacción
            em.getTransaction().begin();

            // Crear el país imaginario
            Country country = new Country();
            country.setCode("XYZ");
            country.setName("Imaginaria");

            // Persistir el país
            em.persist(country);

            // Crear lenguajes nativos
            CountryLanguage lang1 = new CountryLanguage();
            lang1.setId(new CountryLanguageId ("XYZ", "Imaginese"));
            lang1.setCountry(country);
            lang1.setOfficial(true);
            lang1.setPercentage(60.0);

            CountryLanguage lang2 = new CountryLanguage();
            lang2.setId(new CountryLanguageId ("XYZ", "Phantomese"));
            lang2.setCountry(country);
            lang2.setOfficial(false);
            lang2.setPercentage(40.0);

            // Persistir lenguajes
            em.persist(lang1);
            em.persist(lang2);

            // Confirmar transacción
            em.getTransaction().commit();
            System.out.println("Datos persistidos correctamente.");
        } catch (Exception e) {
            // Manejo de errores
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            // Cerrar EntityManager y EntityManagerFactory
            em.close();
            emf.close();
        }
    }
}
