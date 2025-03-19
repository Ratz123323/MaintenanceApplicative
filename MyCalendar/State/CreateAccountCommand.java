package State;

import UsersInformations.*;

import java.util.Optional;
import java.util.Scanner;

public class CreateAccountCommand implements AppStateCommand {
	
	private final Utilisateurs gestionUtilisateurs;
	private final CalendarManager calendar;
	
	public CreateAccountCommand(Utilisateurs gestionUtilisateurs, CalendarManager calendar) {
		this.gestionUtilisateurs = gestionUtilisateurs;
		this.calendar = calendar;
	}
	
	public AppState execute(Scanner scanner) {
		System.out.print("Nom d'utilisateur: ");
		String nom = scanner.nextLine();
		System.out.print("Mot de passe: ");
		String mdp = scanner.nextLine();
		System.out.print("Répéter mot de passe: ");
		String confirmation = scanner.nextLine();
		return Optional.of(confirmation)
				.filter(conf -> conf.equals(mdp))
				.map(conf -> { gestionUtilisateurs.ajouterUtilisateur(new Utilisateur(nom), new MotDePasse(mdp)); System.out.println("Compte créé avec succès."); return new DisconnectedState(gestionUtilisateurs, calendar); })
				.orElseGet(() -> { System.out.println("Les mots de passe ne correspondent pas."); return new DisconnectedState(gestionUtilisateurs, calendar); });
	}
}

