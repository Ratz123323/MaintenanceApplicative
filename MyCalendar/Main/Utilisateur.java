package Main;

public class Utilisateur {
	private final String nom;
	
	public Utilisateur(String nom) {
		if (nom == null || nom.isEmpty()) {
			throw new IllegalArgumentException("Nom d'utilisateur ne peut pas être vide");
		}
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}
	
	@Override
	public String toString() {
		return nom;
	}
}

