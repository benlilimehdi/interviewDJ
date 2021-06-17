package com.example.entrevueSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entrevueSpringBoot.dao.ActeurRepository;
import com.example.entrevueSpringBoot.entity.Acteur;

@Service
public class ActeurServiceImpl implements ActeurService {

	@Autowired
	ActeurRepository acteurRepository;

	public Acteur addActeur(Acteur myActeur) {
		//check if actor exist
		return acteurRepository.save(myActeur);
	}

	
	
	
	
	public Acteur GetActeurByFirstLastName(String Fname, String Lname) {
		return null;
		/*
		// il pourrait avoir des acteurs avec le mme nom et prenom
		// ici je choisi juste le premier acteur
		System.out.println();
		List<Acteur> acteurs = acteurRepository.getByFirstAndLastName(Fname, Lname);
		if (acteurs.size()>0)
			return acteurs.get(0);
		else
			return null;
		*/
	}

}
