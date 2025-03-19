import Evenements.*;
import Evenements.TypeEvenements.*;
import State.*;
import UsersInformations.*;
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

class DeleteEventTest {
	
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
	void testSupprimerEvenementExist() {
		// Ajout d'un événement
		EventId id = new EventId(1);
		TitreEvenement titre = new TitreEvenement("Réunion Projet");
		ProprietaireEvenement proprietaire = new ProprietaireEvenement("TestUser");
		DateDebutEvenement dateDebut = new DateDebutEvenement(LocalDateTime.of(2025, 5, 10, 14, 0));
		DureeMinutesEvenement duree = new DureeMinutesEvenement(60);
		LieuEvenement lieu = new LieuEvenement("Salle 101");
		ParticipantsEvenement participants = new ParticipantsEvenement(Collections.singletonList("Alice, Bob"));
		FrequenceJoursEvenement frequence = new FrequenceJoursEvenement(1);
		PresentateurEvenement presentateur = new PresentateurEvenement("Dr. Smith");
		
		Evenement e = new Evenement(id, titre, proprietaire, dateDebut, duree, lieu, participants, frequence, TypeEvenement.REUNION, presentateur);
		calendar.ajouterEvenement(e);
		
		// Simulation de l'entrée utilisateur pour supprimer l'événement avec l'id 1
		String input = "1\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		DeleteEventCommand command = new DeleteEventCommand(state);
		command.execute(new Scanner(System.in));
		
		// Vérification que l'événement a été supprimé
		String output = outputStream.toString();
		assertTrue(output.contains("Événement supprimé"));
	}
	
	@Test
	void testSupprimerEvenementInexistant() {
		// Simulation de l'entrée utilisateur pour supprimer un événement inexistant (id 999)
		String input = "999\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		DeleteEventCommand command = new DeleteEventCommand(state);
		command.execute(new Scanner(System.in));
		
		// Vérification que le message indique qu'il n'y a pas d'événement à supprimer
		String output = outputStream.toString();
		assertTrue(output.contains("Aucun événement trouvé"));
	}
	
	@Test
	void testSupprimerPuisVerifierSupression() {
		// Ajout d'un événement
		EventId id = new EventId(1);
		TitreEvenement titre = new TitreEvenement("Réunion Projet");
		ProprietaireEvenement proprietaire = new ProprietaireEvenement("TestUser");
		DateDebutEvenement dateDebut = new DateDebutEvenement(LocalDateTime.of(2025, 5, 10, 14, 0));
		DureeMinutesEvenement duree = new DureeMinutesEvenement(60);
		LieuEvenement lieu = new LieuEvenement("Salle 101");
		ParticipantsEvenement participants = new ParticipantsEvenement(Collections.singletonList("Alice, Bob"));
		FrequenceJoursEvenement frequence = new FrequenceJoursEvenement(1);
		PresentateurEvenement presentateur = new PresentateurEvenement("Dr. Smith");
		
		Evenement e = new Evenement(id, titre, proprietaire, dateDebut, duree, lieu, participants, frequence, TypeEvenement.REUNION, presentateur);
		calendar.ajouterEvenement(e);
		
		// Suppression de l'événement
		String inputDelete = "1\n";
		InputStream inDelete = new ByteArrayInputStream(inputDelete.getBytes());
		System.setIn(inDelete);
		DeleteEventCommand deleteCommand = new DeleteEventCommand(state);
		deleteCommand.execute(new Scanner(System.in));
		
		// Vérification de la suppression
		String outputDelete = outputStream.toString();
		assertTrue(outputDelete.contains("Événement supprimé"));
		
		// Vérification qu'il n'y a plus d'événements
		calendar.afficherEvenements();
		String outputAfterDelete = outputStream.toString();
		assertTrue(outputAfterDelete.contains("Aucun événement trouvé"));
	}
}
