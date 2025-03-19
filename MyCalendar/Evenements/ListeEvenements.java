package Evenements;

import Evenements.TypeEvenements.TypeEvenement;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class ListeEvenements {
	private final List<Evenement> evenements;
	
	public ListeEvenements() {
		this.evenements = new ArrayList<>();
	}
	
	public void ajouterEvenement(Evenement evenement) {
		this.evenements.add(evenement);
	}
	
	public List<Evenement> obtenirEvenements() {
		return evenements;
	}
	
	public boolean estVide() {
		return evenements.isEmpty();
	}
	
	public void afficherEvenements() {
		if (evenements.isEmpty()) {
			System.out.println("Aucun événement trouvé.");
		} else {
			for (Evenement e : evenements) {
				System.out.println(e);
			}
		}
	}
	
	public List<Evenement> evenementsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
		List<Evenement> result = new ArrayList<>();
		for (Evenement e : evenements) {
			if (e.type() == TypeEvenement.PERIODIQUE) {
				LocalDateTime temp = e.dateDebut().dateDebut();
				while (temp.isBefore(fin)) {
					if (!temp.isBefore(debut)) {
						result.add(e);
						break;
					}
					temp = temp.plusDays(e.frequenceJours().frequenceJours());
				}
			} else if (!e.dateDebut().dateDebut().isBefore(debut) && !e.dateDebut().dateDebut().isAfter(fin)) {
				result.add(e);
			}
		}
		return result;
	}
	
	public boolean conflit(Evenement e1, Evenement e2) {
		LocalDateTime fin1 = e1.dateDebut().dateDebut().plusMinutes(e1.dureeMinutes().dureeMinutes());
		LocalDateTime fin2 = e2.dateDebut().dateDebut().plusMinutes(e2.dureeMinutes().dureeMinutes());
		
		if (e1.type() == TypeEvenement.PERIODIQUE || e2.type() == TypeEvenement.PERIODIQUE) {
			return false; // Simplification abusive
		}
		
		if (e1.dateDebut().dateDebut().isBefore(fin2) && fin1.isAfter(e2.dateDebut().dateDebut())) {
			return true;
		}
		return false;
	}
}
