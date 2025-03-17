package Evenements.TypeEvenements;

import Evenements.Evenement;

public class ReunionDescription implements EvenementDescription {
	@Override
	public String description(Evenement evenement) {
		return "Réunion : " + evenement.titre() + " à " + evenement.lieu() + " avec " + evenement.participants();
	}
}
