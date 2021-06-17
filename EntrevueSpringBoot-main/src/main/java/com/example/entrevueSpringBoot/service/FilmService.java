package com.example.entrevueSpringBoot.service;

import java.util.Optional;

import com.example.entrevueSpringBoot.entity.Film;

public interface FilmService {
	
	Optional<Film> getFilmDetailsById(long id);
	Film addFilm(Film film);

}
