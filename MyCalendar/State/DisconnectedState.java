package State;

import java.util.Map;
import java.util.Scanner;

import Main.Utilisateurs;

public class DisconnectedState implements AppState {
	private final Map<String, AppStateCommand> commandes;
	public DisconnectedState(Utilisateurs gestionUtilisateurs, CalendarManager calendar) {
		this.commandes = Map.of(
				"1", new ConnectCommand(gestionUtilisateurs, calendar),
				"2", new CreateAccountCommand(gestionUtilisateurs, calendar)
		);
	}
	private void displayBanner() {
		System.out.println("  _____         _                   _                __  __");
		System.out.println(" / ____|       | |                 | |              |  \\/  |");
		System.out.println("| |       __ _ | |  ___  _ __    __| |  __ _  _ __  | \\  / |  __ _  _ __");
		System.out.println("| |      / _` || | / _ \\| '_ \\  / _` | / _` || '__| | |\\/| | / _` || '_ \\");
		System.out.println("| |_____| (_| || ||  __/| | | || (_| || (_| || |    | |  | || (_| || | | |");
		System.out.println(" \\_____| \\__,_||_| \\___||_| |_| \\__,_| \\__,_||_|    |_|  |_| \\__,_||_| |_|");
	}
	private void displayMenu() {
		System.out.println("1 - Se connecter");
		System.out.println("2 - Créer un compte");
		System.out.print("Choix : ");
	}
	public AppState run(Scanner scanner) {
		displayBanner();
		displayMenu();
		String choix = scanner.nextLine();
		AppStateCommand cmd = commandes.getOrDefault(choix, new InvalidCommand(this));
		return cmd.execute(scanner);
	}
}
