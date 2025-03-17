package State;

import java.util.Scanner;

public class DisconnectCommand implements AppStateCommand {
	
	private final ConnectedState state;
	
	public DisconnectCommand(ConnectedState state) {
		this.state = state;
	}
	
	public AppState execute(Scanner scanner) {
		System.out.println("Déconnexion réussie.");
		return new DisconnectedState(state.getGestionUtilisateurs(), state.getCalendar());
	}
}
