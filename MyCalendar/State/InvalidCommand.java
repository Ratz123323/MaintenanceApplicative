package State;

import java.util.Scanner;

public class InvalidCommand implements AppStateCommand {
	private final AppState fallback;
	public InvalidCommand(AppState fallback) { this.fallback = fallback; }
	public AppState execute(Scanner scanner) {
		System.out.println("Choix invalide.");
		return fallback;
	}
}

