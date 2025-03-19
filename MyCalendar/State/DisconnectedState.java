package State;

import java.util.Map;
import java.util.Scanner;

import UsersInformations.Utilisateurs;

public class DisconnectedState implements AppState {
	
	private final Map<String, AppStateCommand> commandes;
	
	public DisconnectedState(Utilisateurs gestionUtilisateurs, CalendarManager calendar) {
		this.commandes = Map.of(
				"1", new ConnectCommand(gestionUtilisateurs, calendar),
				"2", new CreateAccountCommand(gestionUtilisateurs, calendar)
		);
	}
	
	private void displayBanner() {
		System.out.println("""
				   \\  | \\ \\   /      ___|     \\     |      ____|   \\  |  __ \\     \\      _ \\       \\  |     \\      \\  |     \\      ___|  ____|   _ \\ \s
				  |\\/ |  \\   /      |        _ \\    |      __|      \\ |  |   |   _ \\    |   |     |\\/ |    _ \\      \\ |    _ \\    |      __|    |   |\s
				  |   |     |       |       ___ \\   |      |      |\\  |  |   |  ___ \\   __ <      |   |   ___ \\   |\\  |   ___ \\   |   |  |      __ < \s
				 _|  _|    _|      \\____| _/    _\\ _____| _____| _| \\_| ____/ _/    _\\ _| \\_\\    _|  _| _/    _\\ _| \\_| _/    _\\ \\____| _____| _| \\_\\\s
				                                                                                                                                     \s
				""");
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
