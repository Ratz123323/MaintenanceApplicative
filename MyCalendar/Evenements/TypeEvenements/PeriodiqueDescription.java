package Evenements.TypeEvenements;

import Evenements.Evenement;

public class PeriodiqueDescription implements EvenementDescription {
	@Override
	public String description(Evenement evenement) {
		return "Id : " + evenement.id() + ", Événement périodique : " + evenement.titre() + " tous les " + evenement.frequenceJours();
	}
}

