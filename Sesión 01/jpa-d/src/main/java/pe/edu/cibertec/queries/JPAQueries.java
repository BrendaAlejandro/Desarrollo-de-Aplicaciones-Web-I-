package pe.edu.cibertec.queries;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import pe.edu.cibertec.entity.Libro;

import java.util.List;

public class JPAQueries {

    public static void main(String[] args) {

        // referenciar al em
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
        EntityManager em = emf.createEntityManager();

        /**
         * SELECT
         */
//        TypedQuery<Libro> query = em.createQuery("select l from Libro l", Libro.class);
//        query.getResultList().forEach(System.out::println);

        /**
         * SELECT - WHERE
         */
//        TypedQuery<Libro> query = em.createQuery("select l from Libro l where l.autor = :autor and l.precio > :precio", Libro.class);
//        query.setParameter("autor", "Claudia");
//        query.setParameter("precio", 50);
//        query.getResultList().forEach(System.out::println);

        /**
         * SELECT - BETWEEN
         */
//        TypedQuery<Libro> query = em.createQuery("select l from Libro l where l.precio between :inicio and :final", Libro.class);
//        query.setParameter("inicio", 30);
//        query.setParameter("final", 50);
//        query.getResultList().forEach(System.out::println);

        /**
         * SELECT - IN
         */
//        TypedQuery<Libro> query = em.createQuery("select l from Libro l where l.autor in ('Cesar', 'Claudia')", Libro.class);
//        query.getResultList().forEach(System.out::println);

        /**
         * SELECT - VALORES ESCALARES
         */
//        TypedQuery<String> query = em.createQuery("select l.autor from Libro l where l.autor in ('Cesar', 'Claudia')", String.class);
//        query.getResultList().forEach(System.out::println);

        /**
         * SELECT - VALORES ESCALARES - DISTINCT
         */
//        TypedQuery<String> query = em.createQuery("select distinct l.autor from Libro l where l.autor in ('Cesar', 'Claudia')", String.class);
//        query.getResultList().forEach(System.out::println);

        /**
         * SELECT - ORDER BY
         */
//        TypedQuery<Libro> query = em.createQuery("select l from Libro l order by l.precio desc", Libro.class);
//        query.getResultList().forEach(System.out::println);

        /**
         * SELECT - VALORES ESCALARES - GROUP BY
         */
//        TypedQuery<Object[]> query = em.createQuery("select l.autor, count(l) from Libro l group by l.autor", Object[].class);
//        query.getResultList().forEach(item -> System.out.println(item[0] + " -> " + item[1]));

        /**
         * SELECT - IS NULL
         */
//        TypedQuery<Libro> query = em.createQuery("select l from Libro l where l.autor is null", Libro.class);
//        query.getResultList().forEach(System.out::println);

        /**
         * SELECT - LIKE
         */
        TypedQuery<Libro> query = em.createQuery("select l from Libro l where l.titulo like 'c%'", Libro.class);
        query.getResultList().forEach(System.out::println);

    }

}
