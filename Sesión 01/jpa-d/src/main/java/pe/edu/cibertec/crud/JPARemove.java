package pe.edu.cibertec.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.cibertec.entity.Libro;

public class JPARemove {

    public static void main(String[] args) {

        // referenciar al em
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
        EntityManager em = emf.createEntityManager();

        // referenciar al libro
        Libro libro = em.find(Libro.class, "A3");

        // eliminar libro
        em.getTransaction().begin();
        em.remove(libro);
        em.getTransaction().commit();

    }

}
