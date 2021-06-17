package com.example.entrevueSpringBoot.service;

import com.example.entrevueSpringBoot.entity.Acteur;

public interface ActeurService {

	Acteur addActeur(Acteur myActeur);
	Acteur GetActeurByFirstLastName(String Fname,String Lname);
	//Boolean checkIfActeurExistByFirstLastName(String Fname,String Lname);
	
}
