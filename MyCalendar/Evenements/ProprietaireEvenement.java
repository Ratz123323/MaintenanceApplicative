package Evenements;

public record ProprietaireEvenement(String proprietaire) {
	public ProprietaireEvenement {
		if (proprietaire == null || proprietaire.isEmpty()) {
			throw new IllegalArgumentException("Le propriétaire ne peut pas être vide.");
		}
	}
	
	@Override
	public String toString() {
		return proprietaire;
	}
}
