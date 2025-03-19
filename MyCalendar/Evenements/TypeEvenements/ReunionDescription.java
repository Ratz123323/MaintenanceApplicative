package Evenements.TypeEvenements;

import Evenements.Evenement;

public class ReunionDescription implements EvenementDescription {
	@Override
	public String description(Evenement evenement) {
		return "Id : " + evenement.id() + ", Réunion : " + evenement.titre() + " à " + evenement.lieu() + " avec " + evenement.participants();
	}
}
