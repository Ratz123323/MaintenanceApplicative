package State;

import Evenements.DateDebutEvenement;
import jdk.jshell.execution.LoaderDelegate;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ShowEventsInPeriodCommand implements AppStateCommand {
	
	private final ConnectedState state;
	
	public ShowEventsInPeriodCommand(ConnectedState state) {
		this.state = state;
	}
	
	public AppState execute(Scanner scanner) {
		// TODO
		return null;
	}
}
