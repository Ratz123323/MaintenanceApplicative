package Evenements;

public record PresentateurEvenement(String presentateur) {
	@Override
	public String toString() {
		return presentateur;
	}
}
