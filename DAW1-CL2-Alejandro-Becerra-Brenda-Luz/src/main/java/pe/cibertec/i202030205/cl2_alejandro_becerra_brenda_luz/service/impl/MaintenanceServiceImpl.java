package pe.cibertec.i202030205.cl2_alejandro_becerra_brenda_luz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.i202030205.cl2_alejandro_becerra_brenda_luz.dto.FilmDetailDto;
import pe.cibertec.i202030205.cl2_alejandro_becerra_brenda_luz.dto.FilmDto;
import pe.cibertec.i202030205.cl2_alejandro_becerra_brenda_luz.entity.Film;
import pe.cibertec.i202030205.cl2_alejandro_becerra_brenda_luz.entity.Language;
import pe.cibertec.i202030205.cl2_alejandro_becerra_brenda_luz.repository.*;
import pe.cibertec.i202030205.cl2_alejandro_becerra_brenda_luz.service.MaintenanceService;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    @Autowired
    FilmRepository filmRepository;
    @Autowired
    private FilmActorRepository filmActorRepository; // Agregar repositorio para film_actor
    @Autowired
    private FilmCategoryRepository filmCategoryRepository; // Agregar repositorio para film_category
    @Autowired
    private InventoryRepository inventoryRepository; // Agregar repositorio para film_category
    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public List<FilmDto> getAllFilms() {
        List<FilmDto> films = new ArrayList<>();
        Iterable<Film> iterable = filmRepository.findAll();
        iterable.forEach(film -> {
            FilmDto filmDto = new FilmDto(film.getFilmId(),
                    film.getTitle(),
                    film.getLanguage().getName(),
                    film.getRentalRate());
            films.add(filmDto);
        });

        return films;
    }

    @Override
    public FilmDetailDto getFilmById(int id) {
        Optional<Film> optional = filmRepository.findById(id);
        return optional.map(film -> new FilmDetailDto(film.getFilmId(),
                        film.getTitle(),
                        film.getDescription(),
                        film.getReleaseYear(),
                        film.getLanguage().getLanguageId(),
                        film.getLanguage().getName(),
                        film.getRentalDuration(),
                        film.getRentalRate(),
                        film.getLength(),
                        film.getReplacementCost(),
                        film.getRating(),
                        film.getSpecialFeatures(),
                        film.getLastUpdate()))
                .orElse(null);
    }

    @Override
    public Boolean updateFilm(FilmDetailDto filmDetailDto) {
        Optional<Film> optional = filmRepository.findById(filmDetailDto.filmId());
        return optional.map(film -> {
            film.setTitle(filmDetailDto.title());
            film.setDescription(filmDetailDto.description());
            film.setReleaseYear(filmDetailDto.releaseYear());
            film.setRentalDuration(filmDetailDto.rentalDuration());
            film.setRentalRate(filmDetailDto.rentalRate());
            film.setLength(filmDetailDto.length());
            film.setReplacementCost(filmDetailDto.replacementCost());
            film.setRating(filmDetailDto.rating());
            film.setSpecialFeatures(filmDetailDto.specialFeatures());

            LocalDateTime localDateTime = Instant.ofEpochMilli(new java.util.Date().getTime())
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();
            film.setLastUpdate(localDateTime);

            filmRepository.save(film);
            return true;
        }).orElse(false);
    }



    @Override
    public Boolean deleteFilm(int id) {
        Optional<Film> optional = filmRepository.findById(id);
        return optional.map(film -> {
            /*// Paso 1: Eliminar los registros dependientes en film_actor
            filmActorRepository.deleteByFilmId(id);

            // Paso 2: Eliminar los registros dependientes en film_category
            filmCategoryRepository.deleteByFilmId(id);

            // Paso 3:
            inventoryRepository.deleteByFilmId(id);
            */
            // Paso 4: Eliminar la película en la tabla film
            filmRepository.delete(film);
            return true;
        }).orElse(false);
    }

    @Override
    public FilmDetailDto createFilm(FilmDetailDto filmDetailDto) {
        Film film = new Film();
        film.setTitle(filmDetailDto.title());
        film.setDescription(filmDetailDto.description());
        film.setReleaseYear(filmDetailDto.releaseYear());
        film.setRentalDuration(filmDetailDto.rentalDuration());
        film.setRentalRate(filmDetailDto.rentalRate());
        film.setLength(filmDetailDto.length());
        film.setReplacementCost(filmDetailDto.replacementCost());
        film.setRating(filmDetailDto.rating());
        film.setSpecialFeatures(filmDetailDto.specialFeatures());
        LocalDateTime localDateTime = Instant.ofEpochMilli(new java.util.Date().getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        film.setLastUpdate(localDateTime);
        Optional<Language> languageOptional = languageRepository.findById(filmDetailDto.languageId());
        if (languageOptional.isPresent()) {
            film.setLanguage(languageOptional.get());
        } else {
            Language newLanguage = new Language();
            newLanguage.setLanguageId(filmDetailDto.languageId());
            film.setLanguage(newLanguage);}
        Film savedFilm = filmRepository.save(film);
        return new FilmDetailDto(
                savedFilm.getFilmId(),
                savedFilm.getTitle(),
                savedFilm.getDescription(),
                savedFilm.getReleaseYear(),
                savedFilm.getLanguage().getLanguageId(),
                savedFilm.getLanguage().getName(),
                savedFilm.getRentalDuration(),
                savedFilm.getRentalRate(),
                savedFilm.getLength(),
                savedFilm.getReplacementCost(),
                savedFilm.getRating(),
                savedFilm.getSpecialFeatures(),
                savedFilm.getLastUpdate()
        );
    }
}