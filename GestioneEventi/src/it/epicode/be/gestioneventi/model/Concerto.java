package it.epicode.be.gestioneventi.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@NamedQuery(name = "concertiInStreaming", query = "select c from Concerto c where c.inStreaming = :streaming")
@NamedQuery(name = "concertiPerGenere", query = "select c from Concerto c where c.genere = :listagenere")
public class Concerto extends Evento{
	
	@Enumerated(EnumType.STRING)
	private GenereConcerto genere;
	
	private Boolean inStreaming;
}
