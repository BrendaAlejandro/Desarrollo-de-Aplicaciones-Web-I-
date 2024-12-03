package pe.edu.i202030205.cl1_jpa_data_alejandro_brenda.connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ConexionesConfig {

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();

        // Configuración del pool
        config.setMaximumPoolSize(30);
        config.setMinimumIdle(4);
        config.setIdleTimeout(240000);
        config.setConnectionTimeout(45000);

        // Configuración de la base de datos
        config.setJdbcUrl("jdbc:mysql://localhost:3306/tu_base_de_datos"); // Cambiar URL
        config.setUsername("tu_usuario"); // Cambiar usuario
        config.setPassword("tu_contraseña"); // Cambiar contraseña
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");

        return new HikariDataSource(config);
    }
}