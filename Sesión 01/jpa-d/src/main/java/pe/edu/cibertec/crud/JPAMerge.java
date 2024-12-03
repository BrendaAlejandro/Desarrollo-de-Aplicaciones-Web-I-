package pe.edu.cibertec.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.cibertec.entity.Libro;

public class JPAMerge {

    public static void main(String[] args) {

        // referenciar al em
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
        EntityManager em = emf.createEntityManager();

        // referenciar al libro
        Libro libro = em.find(Libro.class, "A1");
        libro.setAutor("Gabriel García Marquez");

        // actualizar libro
        em.getTransaction().begin();
        em.merge(libro);
        em.getTransaction().commit();

    }

}
