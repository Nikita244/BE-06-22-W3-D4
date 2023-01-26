package it.epicode.be.gestioneventi.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@NamedQuery(name = "garePerVincitore", query = "select g from GaraDiAtletica g where g.vincitore = :persona")
@NamedQuery(name = "garePerPartecipante", query = "select g from GaraDiAtletica g where :persona member of g.setAtleti")
public class GaraDiAtletica extends Evento{
	
	@ManyToMany
	private Set<Persona> setAtleti;
	
	@ManyToOne
	private Persona vincitore;
}
