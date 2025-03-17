package Main;

import java.util.HashMap;
import java.util.Map;

public class Utilisateurs {
	private final Map<String, Utilisateur> utilisateurs;
	private final Map<String, MotDePasse> motsDePasses;
	
	public Utilisateurs() {
		utilisateurs = new HashMap<>();
		motsDePasses = new HashMap<>();
	}
	
	public void ajouterUtilisateur(Utilisateur utilisateur, MotDePasse motDePasse) {
		utilisateurs.put(utilisateur.getNom(), utilisateur);
		motsDePasses.put(utilisateur.getNom(), motDePasse);
	}
	
	public boolean validerUtilisateur(String nom, String motDePasse) {
		MotDePasse mdp = motsDePasses.get(nom);
		return mdp != null && mdp.verifier(motDePasse);
	}
	
	public Utilisateur getUtilisateur(String nom) {
		return utilisateurs.get(nom);
	}
}
