package Evenements.TypeEvenements;

import Evenements.Evenement;

public class RdvPersonnelDescription implements EvenementDescription {
	@Override
	public String description(Evenement evenement) {
		return "RDV : " + evenement.titre() + " à " + evenement.dateDebut();
	}
}

