package com.example.entrevueSpringBoot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entrevueSpringBoot.dao.FilmRepository;
import com.example.entrevueSpringBoot.entity.Film;

@Service
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmRepository filmRepository;
	
	/**
	 *  return Optional<Film>
	 */
	public Optional<Film> getFilmDetailsById(long idFilm) {
		return filmRepository.findById(idFilm);
	}

	/**
	 * return the saved film
	 */
	public Film addFilm(Film film) {
		return filmRepository.save(film) ;
	}

}
