package pe.edu.cibertec.relations;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.cibertec.entity.Categoria;
import pe.edu.cibertec.entity.Libro;

public class JPAOneToManyOrphan {

    public static void main(String[] args) {

        // referenciar al em
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
        EntityManager em = emf.createEntityManager();

        // obtener categoria
        Categoria categoria = em.find(Categoria.class, "C1");

        // obtener libro
        Libro libro = em.find(Libro.class, "A9");

        // eliminar el hijo de la categoria
        categoria.getLibros().remove(libro);

        // merge
        em.getTransaction().begin();
        em.merge(categoria);
        em.getTransaction().commit();

    }

}
