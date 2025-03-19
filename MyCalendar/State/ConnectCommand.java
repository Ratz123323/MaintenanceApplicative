package State;

import UsersInformations.*;

import java.util.Optional;
import java.util.Scanner;

public class ConnectCommand implements AppStateCommand {
	private final Utilisateurs gestionUtilisateurs;
	private final CalendarManager calendar;
	
	public ConnectCommand(Utilisateurs gestionUtilisateurs, CalendarManager calendar) {
		this.gestionUtilisateurs = gestionUtilisateurs;
		this.calendar = calendar;
	}
	
	public AppState execute(Scanner scanner) {
		System.out.print("Nom d'utilisateur: ");
		String nom = scanner.nextLine();
		System.out.print("Mot de passe: ");
		String mdp = scanner.nextLine();
		Optional<Utilisateur> opt = gestionUtilisateurs.ajouterUtilisateur(new Utilisateur(nom), new MotDePasse(mdp));
		return opt.<AppState>map(u -> new ConnectedState(u, gestionUtilisateurs, calendar))
				.orElseGet(() -> {
					System.out.println("Nom d'utilisateur ou mot de passe incorrect.");
					return new DisconnectedState(gestionUtilisateurs, calendar);
				});
	}
}

