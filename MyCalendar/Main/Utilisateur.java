package Main;

public record Utilisateur(String nom) {
	public Utilisateur {
		if (nom == null || nom.isEmpty()) {
			throw new IllegalArgumentException("Nom d'utilisateur ne peut pas être vide");
		}
	}
	
	@Override
	public String toString() {
		return nom;
	}
}

