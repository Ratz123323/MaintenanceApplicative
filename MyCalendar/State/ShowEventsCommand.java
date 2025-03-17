package State;

import java.util.Scanner;

public class ShowEventsCommand implements AppStateCommand {
	
	private final ConnectedState state;
	
	public ShowEventsCommand(ConnectedState state) {
		this.state = state;
	}
	
	public AppState execute(Scanner scanner) {
		state.getCalendar().afficherEvenements();
		return state;
	}
}
