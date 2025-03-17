package Main;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Utilisateurs {
	private final Map<String, Utilisateur> utilisateurs;
	private final Map<String, MotDePasse> motsDePasses;
	
	public Utilisateurs() {
		utilisateurs = new HashMap<>();
		motsDePasses = new HashMap<>();
	}
	
	public Optional<Utilisateur> ajouterUtilisateur(Utilisateur utilisateur, MotDePasse motDePasse) {
		utilisateurs.put(utilisateur.nom(), utilisateur);
		motsDePasses.put(utilisateur.nom(), motDePasse);
		return Optional.of(utilisateur);
	}
	
	public boolean validerUtilisateur(String nom, String motDePasse) {
		MotDePasse mdp = motsDePasses.get(nom);
		return mdp != null && mdp.verifier(motDePasse);
	}
	
	public Utilisateur getUtilisateur(String nom) {
		return utilisateurs.get(nom);
	}
}
