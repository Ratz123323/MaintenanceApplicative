package Evenements.TypeEvenements;

import Evenements.Evenement;

public class PeriodiqueDescription implements EvenementDescription {
	@Override
	public String description(Evenement evenement) {
		return "Événement périodique : " + evenement.titre() + " tous les " + evenement.frequenceJours();
	}
}

