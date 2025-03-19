import Evenements.*;
import Evenements.TypeEvenements.*;
import State.*;
import Main.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ShowEventsInPeriodTest {
	
	private ConnectedState state;
	private CalendarManager calendar;
	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	
	@BeforeEach
	void setUp() {
		Utilisateurs gestionUtilisateurs = new Utilisateurs();
		Utilisateur utilisateur = new Utilisateur("TestUser");
		calendar = new CalendarManager();
		state = new ConnectedState(utilisateur, gestionUtilisateurs, calendar);
		System.setOut(new PrintStream(outputStream));
	}
	
	@Test
	void testObtenirEvenementsDansPeriode() {
		// Ajout d'un événement dans la période
		TitreEvenement titre = new TitreEvenement("Réunion Projet");
		ProprietaireEvenement proprietaire = new ProprietaireEvenement("TestUser");
		DateDebutEvenement dateDebut = new DateDebutEvenement(LocalDateTime.of(2025, 5, 10, 14, 0));
		DureeMinutesEvenement duree = new DureeMinutesEvenement(60);
		LieuEvenement lieu = new LieuEvenement("Salle 101");
		ParticipantsEvenement participants = new ParticipantsEvenement(Collections.singletonList("Alice, Bob"));
		FrequenceJoursEvenement frequence = new FrequenceJoursEvenement(1);
		PresentateurEvenement presentateur = new PresentateurEvenement("Dr. Smith");
		
		calendar.ajouterEvenement(titre, proprietaire, dateDebut, duree, lieu, participants, frequence, TypeEvenement.REUNION, presentateur);
		
		// Simulation de l'entrée utilisateur pour une période contenant l'événement
		String input = "2025\n5\n10\n13\n30\n2025\n5\n10\n15\n00\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		ShowEventsInPeriodCommand command = new ShowEventsInPeriodCommand(state);
		command.execute(new Scanner(System.in));
		
		String output = outputStream.toString();
		assertTrue(output.contains("Réunion Projet"));
		assertTrue(output.contains("Salle 101"));
	}
}
