package State;

import Evenements.*;
import Evenements.TypeEvenements.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Scanner;

public class AddConferenceCommand implements AppStateCommand {
	
	private final ConnectedState state;
	
	public AddConferenceCommand(ConnectedState state) {
		this.state = state;
	}
	
	public AppState execute(Scanner scanner) {
		// TODO
		return null;
	}
}
