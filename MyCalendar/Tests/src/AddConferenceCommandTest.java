import State.*;
import Main.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AddConferenceCommandTest {
	
	private ConnectedState state;
	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	
	@BeforeEach
	void setUp() {
		Utilisateurs gestionUtilisateurs = new Utilisateurs();
		Utilisateur utilisateur = new Utilisateur("TestUser");
		CalendarManager calendar = new CalendarManager();
		state = new ConnectedState(utilisateur, gestionUtilisateurs, calendar);
		System.setOut(new PrintStream(outputStream));
	}
	
	@Test
	void testAjoutConference() {
		String input = "Conférence IA\n2025\n5\n10\n14\n30\n90\nSalle 101\nDr. Smith\nAlice, Bob\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		AddConferenceCommand command = new AddConferenceCommand(state);
		command.execute(new Scanner(System.in));
		
		String output = outputStream.toString();
		assertTrue(output.contains("Conférence ajoutée avec le présentateur : Dr. Smith"));
	}
}
