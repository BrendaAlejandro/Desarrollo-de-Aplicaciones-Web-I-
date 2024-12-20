package pe.cibertec.i202030205.cl2_alejandro_becerra_brenda_luz.service;


import pe.cibertec.i202030205.cl2_alejandro_becerra_brenda_luz.dto.FilmDetailDto;
import pe.cibertec.i202030205.cl2_alejandro_becerra_brenda_luz.dto.FilmDto;

import java.util.List;

public interface MaintenanceService {

    List<FilmDto> getAllFilms();
    FilmDetailDto getFilmById(int id);
    Boolean updateFilm(FilmDetailDto filmDetailDto);
    Boolean deleteFilm(int id);
    FilmDetailDto createFilm(FilmDetailDto filmDetailDto);
}