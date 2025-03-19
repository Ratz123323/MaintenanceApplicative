package State;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

import Main.*;

public class ConnectedState implements AppState {
	private final Utilisateur utilisateur;
	private final Utilisateurs gestionUtilisateurs;
	private final CalendarManager calendar;
	private final Map<String, Function<ConnectedState, AppStateCommand>> commandes;
	public ConnectedState(Utilisateur utilisateur, Utilisateurs gestionUtilisateurs, CalendarManager calendar) {
		this.utilisateur = utilisateur;
		this.gestionUtilisateurs = gestionUtilisateurs;
		this.calendar = calendar;
		this.commandes = Map.of(
				"1", ShowEventsCommand::new,
				"2", AddRdvCommand::new,
				"3", AddReunionCommand::new,
				"4", AddConferenceCommand::new,
				"5", AddPeriodicCommand::new,
				"6", DisconnectCommand::new
		);
	}
	private void displayMenu() {
		System.out.println("\nBonjour, " + utilisateur.nom());
		System.out.println("=== Menu Gestionnaire d'Événements ===");
		System.out.println("1 - Voir les événements");
		System.out.println("2 - Ajouter un rendez-vous perso");
		System.out.println("3 - Ajouter une réunion");
		System.out.println("4 - Ajouter une conférence");
		System.out.println("5 - Ajouter un évènement périodique");
		System.out.println("6 - Se déconnecter");
		System.out.print("Votre choix : ");
	}
	public AppState run(Scanner scanner) {
		displayMenu();
		String choix = scanner.nextLine();
		AppStateCommand cmd = commandes.getOrDefault(choix, InvalidCommand::new).apply(this);
		return cmd.execute(scanner);
	}
	public Utilisateur getUtilisateur() { return utilisateur; }
	public Utilisateurs getGestionUtilisateurs() { return gestionUtilisateurs; }
	public CalendarManager getCalendar() { return calendar; }
}
