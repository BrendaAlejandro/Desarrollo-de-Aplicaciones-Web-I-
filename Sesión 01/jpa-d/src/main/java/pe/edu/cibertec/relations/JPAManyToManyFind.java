package pe.edu.cibertec.relations;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.cibertec.entity.Curso;
import pe.edu.cibertec.entity.Estudiante;

public class JPAManyToManyFind {

    public static void main(String[] args) {

        // referenciar al em
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
        EntityManager em = emf.createEntityManager();

        // mostrar cursos de un estudiante
        Estudiante estudiante = em.find(Estudiante.class, "E1");
        System.out.println("----------------------------------------");
        System.out.println(String.format("Cursos del estudiante %s", estudiante.getNombres()));
        estudiante.getCursos().forEach(System.out::println);

        // mostrar estudiantes de un curso
        Curso curso = em.find(Curso.class, "C5");
        System.out.println("----------------------------------------");
        System.out.println(String.format("Alumnos del curso %s", curso.getNombre()));
        curso.getEstudiantes().forEach(System.out::println);

    }

}
