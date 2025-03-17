package Evenements;

public class ProprietaireEvenement {
	private final String proprietaire;
	
	public ProprietaireEvenement(String proprietaire) {
		if (proprietaire == null || proprietaire.isEmpty()) {
			throw new IllegalArgumentException("Le propriétaire ne peut pas être vide.");
		}
		this.proprietaire = proprietaire;
	}
	
	public String getProprietaire() {
		return proprietaire;
	}
	
	@Override
	public String toString() {
		return proprietaire;
	}
}
