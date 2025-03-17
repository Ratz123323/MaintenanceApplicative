package Evenements;

public record TitreEvenement(String titre) {
	public TitreEvenement {
		if (titre == null || titre.isEmpty()) {
			throw new IllegalArgumentException("Le titre ne peut pas être vide.");
		}
	}
	
	@Override
	public String toString() {
		return titre;
	}
}

