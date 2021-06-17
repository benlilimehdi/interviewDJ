package com.example.entrevueSpringBoot.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entrevueSpringBoot.dao.ActeurRepository;
import com.example.entrevueSpringBoot.entity.Acteur;
import com.example.entrevueSpringBoot.entity.Film;
import com.example.entrevueSpringBoot.service.ActeurServiceImpl;
import com.example.entrevueSpringBoot.service.FilmServiceImpl;

@RestController
public class FilmController {

	@Autowired
	private FilmServiceImpl filmServiceImpl;

	@Autowired
	private ActeurServiceImpl acteurServiceImpl;

	
	
	
	@RequestMapping(value = "film/getDetailsById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Film> getFilmDetailsByID(@PathVariable("id") int idFilm) {

		// Get film by id IF EXIST
		Optional<Film> myFilm = filmServiceImpl.getFilmDetailsById(idFilm);

		// if the Optional<Film> is empty
		if (!myFilm.isPresent())
			return new ResponseEntity<Film>(HttpStatus.NOT_FOUND);
		else
			// the Optional<Film> is NOT empty
			return new ResponseEntity<Film>(myFilm.get(), HttpStatus.OK);
	}

	
	
	
	@PostMapping(value = "film/addFilm", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Film> addFilm(@RequestBody Film myFilm) {

		// System.out.println(myFilm);
		// verifiedActeur est une liste pour ajouté les acteurs avec leurs id existant
		// si l'acteur n'existe pas; on le persiste puis on ajoute a la liste
		Collection<Acteur> verifiedActeur = new ArrayList<Acteur>();
		for (Acteur act : myFilm.getActeurs()) {
			/*
			 * Acteur testActeur=acteurServiceImpl.GetActeurByFirstLastName(act.getNom(),
			 * act.getPrenom());
			 * 
			 * if (testActeur != null) { verifiedActeur.add(testActeur); } else { Acteur
			 * newActeur=acteurServiceImpl.addActeur(act); verifiedActeur.add(newActeur); }
			 */

			Acteur newActeur = acteurServiceImpl.addActeur(act);
			verifiedActeur.add(newActeur);

		}

		myFilm.setActeurs(verifiedActeur);

		Film createdFilm = filmServiceImpl.addFilm(myFilm);
		if (createdFilm == null) {
			return new ResponseEntity<Film>(HttpStatus.EXPECTATION_FAILED);
		} else
			return new ResponseEntity<Film>(myFilm, HttpStatus.CREATED);
	}

}
