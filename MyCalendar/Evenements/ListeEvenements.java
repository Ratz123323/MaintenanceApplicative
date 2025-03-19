package Evenements;

import Evenements.TypeEvenements.TypeEvenement;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
	
	public void ajouterSiPasDeConflit(Evenement event){
		boolean conflit = false;
		
		for (Evenement e : evenements){
			if(verifierConflit(event, e)){
				conflit = true;
				System.out.println("Conflit avec l'événement suivant : " + e);
				break;
			}
		}
		if(!conflit){
			EventId id = getCorrectId(event.id());
			Evenement goodEvent = new Evenement(id, event.titre(), event.proprietaire(), event.dateDebut(), event.dureeMinutes(), event.lieu(), event.participants(), event.frequenceJours(), event.type(), event.presentateur());
			ajouterEvenement(goodEvent);
		}
	}
	
	public boolean verifierConflit(Evenement e1, Evenement e2) {
		return conflit(e1, e2);
	}
	
	public void affichageConflit(List<Evenement> events){
		if (events.isEmpty()) {
			System.out.println("Aucun événement trouvé.");
		} else {
			for (Evenement e : events) {
				System.out.println(e);
			}
		}
	}
	
	public void supprimerEvenement(EventId id) {
		for (Evenement e : evenements) {
			if (e.id().equals(id)) {
				evenements.remove(e);
				System.out.println("Événement supprimé");
				return;
			}
		}
		System.out.println("Aucun événement trouvé");
	}
	
	public EventId getCorrectId(EventId id){
		for (Evenement e : evenements){
			if(e.id().equals(id)){
				return getCorrectId(id.increment());
			}
		}
		return id;
	}
}
