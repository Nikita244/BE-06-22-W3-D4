package it.epicode.be.gestioneventi.model;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

import lombok.Getter;

import lombok.Setter;

@Entity
@Getter
@Setter
@NamedQuery(name = "partiteVinteInCasa", query = "select p from PartitaDiCalcio p where p.squadraVincente = :squadraDiCasa")
@NamedQuery(name = "partiteVinteInTrasferta", query = "select p from PartitaDiCalcio p where p.squadraVincente = :squadraOspite")
@NamedQuery(name = "partitePareggiate", query = "select p from PartitaDiCalcio p where p.squadraVincente is null")
public class PartitaDiCalcio extends Evento {
	
	private String squadraDiCasa;
	private String squadraOspite;
	private String squadraVincente;
	private Integer numGolCasa = 0;
	public String getSquadraDiCasa() {
		return squadraDiCasa;
	}
	
}
