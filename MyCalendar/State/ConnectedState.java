package State;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

import UsersInformations.*;

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
				"2", ShowEventsInPeriodCommand::new,
				"3", AddRdvCommand::new,
				"4", AddReunionCommand::new,
				"5", AddConferenceCommand::new,
				"6", AddPeriodicCommand::new,
				"7", DeleteEventCommand::new,
				"8", DisconnectCommand::new
		);
	}
	
	private void displayMenu() {
		System.out.println("\nBonjour, " + utilisateur.nom());
		System.out.println("=== Menu Gestionnaire d'Événements ===");
		System.out.println("1 - Voir les événements");
		System.out.println("2 - Voir les événements dans une période donnée");
		System.out.println("3 - Ajouter un rendez-vous perso");
		System.out.println("4 - Ajouter une réunion");
		System.out.println("5 - Ajouter une conférence");
		System.out.println("6 - Ajouter un évènement périodique");
		System.out.println("7 - Supprimer un événement");
		System.out.println("8 - Se déconnecter");
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
