package State;

import java.util.Scanner;

public interface AppStateCommand {
	AppState execute(Scanner scanner);
}
