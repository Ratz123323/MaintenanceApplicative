package Evenements.TypeEvenements;

import Evenements.Evenement;

public class ConferenceDescription implements EvenementDescription {
	@Override
	public String description(Evenement evenement) {
		return "Id : " + evenement.id() + ", Conférence : " + evenement.titre() + " à " + evenement.lieu() + " avec " + evenement.participants() + ". Présentateur : ";
	}
}
