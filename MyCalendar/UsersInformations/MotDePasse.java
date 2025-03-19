package UsersInformations;

public class MotDePasse {
	private final String motDePasse;
	
	public MotDePasse(String motDePasse) {
		if (motDePasse == null || motDePasse.isEmpty()) {
			throw new IllegalArgumentException("Le mot de passe ne peut pas être vide");
		}
		this.motDePasse = motDePasse;
	}
	
	public boolean verifier(String autreMotDePasse) {
		return motDePasse.equals(autreMotDePasse);
	}
	
	@Override
	public String toString() {
		return motDePasse;
	}
}

