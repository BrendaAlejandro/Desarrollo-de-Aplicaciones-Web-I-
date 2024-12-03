package pe.edu.i202030205.cl1_jpa_data_alejandro_brenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.i202030205.cl1_jpa_data_alejandro_brenda.repository.CountryRepository;

import java.util.List;


@SpringBootApplication
public class Cl1JpaDataAlejandroBrendaApplication implements CommandLineRunner {

	@Autowired
	private CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(Cl1JpaDataAlejandroBrendaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Consulta con ifPresentOrElse
		countryRepository.findById("ARG").ifPresentOrElse(
				country -> country.getLanguages().forEach(lang ->
						System.out.println("Language: " + lang.getLanguage())),
				() -> countryRepository.findById("PER").ifPresent(peru ->
						peru.getLanguages().forEach(lang ->
								System.out.println("Language: " + lang.getLanguage())))
		);

		// Eliminar países con deleteAllById
		countryRepository.deleteAllById(List.of("COL", "ARG"));

		// Volver a ejecutar la consulta
		countryRepository.findById("PER").ifPresent(peru ->
				peru.getLanguages().forEach(lang ->
						System.out.println("Language: " + lang.getLanguage())));
	}
}
