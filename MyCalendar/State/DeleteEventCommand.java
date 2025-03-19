package State;

import Evenements.*;
import java.util.Scanner;

public class DeleteEventCommand implements AppStateCommand {
	
	private final ConnectedState state;
	
	public DeleteEventCommand(ConnectedState state) {
		this.state = state;
	}
	
	public AppState execute(Scanner scanner) {
		System.out.print("Numéro de l'évenement à supprimer : ");
		int nb = scanner.nextInt();
		
		EventId id = new EventId(nb);
		
		state.getCalendar().supprimerEvenement(id);
		return state;
	}
}
