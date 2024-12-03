package pe.edu.cibertec.generate;

import jakarta.persistence.Persistence;

public class JPAGenerate {

    public static void main(String[] args) {

        // generar esquema
        Persistence.generateSchema("biblioteca", null);

    }

}
