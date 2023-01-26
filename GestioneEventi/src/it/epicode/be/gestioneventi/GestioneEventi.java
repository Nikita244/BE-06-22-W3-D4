package it.epicode.be.gestioneventi;

import java.util.Date;
import java.util.GregorianCalendar;

import it.epicode.be.gestioneventi.model.Concerto;
import it.epicode.be.gestioneventi.model.Evento;
import it.epicode.be.gestioneventi.model.GenereConcerto;
import it.epicode.be.gestioneventi.model.Location;
import it.epicode.be.gestioneventi.model.Partecipazione;
import it.epicode.be.gestioneventi.model.Persona;
import it.epicode.be.gestioneventi.model.Sesso;
import it.epicode.be.gestioneventi.model.StatoPartecipazione;
import it.epicode.be.gestioneventi.model.TipoEvento;
import it.epicode.be.gestioneventi.model.dao.EventoDAO;
import it.epicode.be.gestioneventi.model.dao.LocationDAO;
import it.epicode.be.gestioneventi.model.dao.PartecipazioneDAO;
import it.epicode.be.gestioneventi.model.dao.PersonaDAO;

public class GestioneEventi {

	public static void main(String[] args) {
		
		/*Location location = saveLocation();
		Evento evento = saveEvento(location);
		Persona persona = savePersona();
		
		Partecipazione partecipazione = savePartecipazione(evento,persona);*/
		
		Concerto c1 = new Concerto();
		c1.setTitolo("Concerto di Capodanno");
		c1.setDataEvento(new GregorianCalendar(2023,9, 23).getTime());
		c1.setDescrizione("musica insieme");
		c1.setTipoEvento(TipoEvento.PUBBLICO);
		c1.setNumeroMassimoPartecipanti(5000);
		//c1.setSetPartecipazioni(StatoPartecipazione.CONFERMATA);
		c1.setLocation(saveLocation());
		c1.setGenere(GenereConcerto.ROCK);
		c1.setInStreaming(false);
		System.out.println("miracolo");
		EventoDAO.save(c1);
	}



	private static Partecipazione savePartecipazione(Evento evento, Persona persona) {
		Partecipazione part = new Partecipazione();
		part.setEvento(evento);
		part.setPersona(persona);
		part.setStato(StatoPartecipazione.CONFERMATA);
		
		PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO();
		partecipazioneDAO.save(part);
		return part;
	}

	private static Persona savePersona() {
		Persona per = new Persona();
		per.setNome("Giuseppe");
		per.setCognome("Rossi");
		per.setEmail("m.rossi@google.com");
		per.setSesso(Sesso.MASCHIO);
		per.setDataDiNascita(new GregorianCalendar(1980,9, 23).getTime());
		PersonaDAO personaDAO = new PersonaDAO();
		personaDAO.save(per);
		System.out.println("tutto ok");
		return per;
	}

	private static Location saveLocation() {
		Location loc = new Location();
		loc.setCitta("Firenze");
		loc.setNome("Stadio Franchi");
		
		LocationDAO locationDAO = new LocationDAO();
		locationDAO.save(loc);
		return loc;
	}

	private static Evento saveEvento(Location loc) {
		Evento ev = new Evento();
		ev.setDataEvento(new Date());
		ev.setTitolo("Partita");
		ev.setDescrizione("Finale di coppa");
		ev.setNumeroMassimoPartecipanti(10);
		ev.setTipoEvento(TipoEvento.PUBBLICO);
		ev.setLocation(loc);
		
		EventoDAO evDao = new EventoDAO();
		evDao.save(ev);
		return ev;
	}

}
