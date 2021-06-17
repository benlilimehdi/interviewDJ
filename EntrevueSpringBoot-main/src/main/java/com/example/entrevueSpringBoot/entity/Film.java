package com.example.entrevueSpringBoot.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author Mahdi Ben Ellili
 *
 */

@Entity
public class Film {

	@Id
	@GeneratedValue
	private long id;
	private String titre;
	private String description;

	@JsonIgnoreProperties("films")
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "acteur_film", joinColumns = { @JoinColumn(name = "film_id") }, inverseJoinColumns = {
			@JoinColumn(name = "acteur_id") })
	private Collection<Acteur> acteurs = new ArrayList();

	/**
	 * Constructeur avec parametres
	 * 
	 * @param titre
	 * @param description
	 */

	public Film(String titre, String description) {
		super();
		this.titre = titre;
		this.description = description;
	}

	public Film() {
	}

	/**
	 * Getters & setters
	 */

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Collection<Acteur> getActeurs() {
		return acteurs;
	}

	public void setActeurs(Collection<Acteur> acteurs) {
		this.acteurs = acteurs;
	}

	public void addActeur(Acteur acteur) {
		this.getActeurs().add(acteur);
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", titre=" + titre + ", description=" + description + ", acteurs=" + acteurs + "]";
	}

	public Film(long id, String titre, String description, Collection<Acteur> acteurs) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.acteurs = acteurs;
	}

}
