package Evenements;

public class TitreEvenement {
	private final String titre;
	
	public TitreEvenement(String titre) {
		if (titre == null || titre.isEmpty()) {
			throw new IllegalArgumentException("Le titre ne peut pas être vide.");
		} else if(titre.length() < 3){
			throw new IllegalArgumentException("Le titre doit contenir au moins 3 caractères.");
		}
		this.titre = titre;
	}
	
	public String getTitre() {
		return titre;
	}
	
	@Override
	public String toString() {
		return titre;
	}
}

