package pe.cibertec.i202030205.cl2_alejandro_becerra_brenda_luz.dto;

import java.time.LocalDateTime;
import java.util.Date;

public record FilmDetailDto(Integer filmId,
                            String title,
                            String description,
                            Integer releaseYear,
                            Integer languageId,
                            String languageName,
                            Integer rentalDuration,
                            Double rentalRate,
                            Integer length,
                            Double replacementCost,
                            String rating,
                            String specialFeatures,
                            LocalDateTime lastUpdate) {


}
