package Evenements;

public record TitreEvenement(String titre) {
	public TitreEvenement {
		if (titre == null || titre.isEmpty()) {
			throw new IllegalArgumentException("Le titre ne peut pas être vide.");
		} else if (titre.length() < 3) {
			throw new IllegalArgumentException("Le titre doit contenir au moins 3 caractères.");
		}
	}
	
	@Override
	public String toString() {
		return titre;
	}
}

