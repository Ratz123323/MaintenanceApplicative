import Evenements.TypeEvenement;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class ListeEvenements {
	private List<Event> events;
	
	public ListeEvenements() {
		this.events = new ArrayList<>();
	}
	
	public void ajouterEvenement(Event event) {
		this.events.add(event);
	}
	
	public List<Event> obtenirEvenements() {
		return events;
	}
	
	public boolean estVide() {
		return events.isEmpty();
	}
	
	public void afficherEvenements() {
		if (events.isEmpty()) {
			System.out.println("Aucun événement trouvé.");
		} else {
			for (Event e : events) {
				System.out.println(e);
			}
		}
	}
	
	public List<Event> evenementsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
		List<Event> result = new ArrayList<>();
		for (Event e : events) {
			if (e.getType() == TypeEvenement.PERIODIQUE) {
				LocalDateTime temp = e.getDateDebut().getDateDebut();
				while (temp.isBefore(fin)) {
					if (!temp.isBefore(debut)) {
						result.add(e);
						break;
					}
					temp = temp.plusDays(e.getFrequenceJours().getFrequenceJours());
				}
			} else if (!e.getDateDebut().getDateDebut().isBefore(debut) && !e.getDateDebut().getDateDebut().isAfter(fin)) {
				result.add(e);
			}
		}
		return result;
	}
	
	public boolean conflit(Event e1, Event e2) {
		LocalDateTime fin1 = e1.getDateDebut().getDateDebut().plusMinutes(e1.getDureeMinutes().getDureeMinutes());
		LocalDateTime fin2 = e2.getDateDebut().getDateDebut().plusMinutes(e2.getDureeMinutes().getDureeMinutes());
		
		if (e1.getType() == TypeEvenement.PERIODIQUE || e2.getType() == TypeEvenement.PERIODIQUE) {
			return false; // Simplification abusive
		}
		
		if (e1.getDateDebut().getDateDebut().isBefore(fin2) && fin1.isAfter(e2.getDateDebut().getDateDebut())) {
			return true;
		}
		return false;
	}
}
