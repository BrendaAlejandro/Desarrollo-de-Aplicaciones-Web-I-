package pe.edu.cibertec.relations;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.cibertec.entity.Categoria;
import pe.edu.cibertec.entity.Libro;

import java.util.Arrays;
import java.util.Date;

public class JPAOneToManyPersist {

    public static void main(String[] args) {

        // referenciar al em
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
        EntityManager em = emf.createEntityManager();

        // crear categoria
        Categoria categoria = new Categoria("C100", "Categoría 100", null);

        // crear libros
        Libro libro01 = new Libro("A101", "Título", "Autor", new Date(), 50.45, categoria);
        Libro libro02 = new Libro("A102", "Título", "Autor", new Date(), 50.45, categoria);
        Libro libro03 = new Libro("A103", "Título", "Autor", new Date(), 50.45, categoria);

        // agregar lista de libros a categoria
        categoria.setLibros(Arrays.asList(libro01, libro02, libro03));

        // persist
        em.getTransaction().begin();
        em.persist(categoria);
        em.getTransaction().commit();

    }

}
