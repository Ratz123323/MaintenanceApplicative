import Evenements.*;
import Evenements.TypeEvenements.*;
import State.*;
import UsersInformations.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

class DetectEventConflictTest {
	
	private CalendarManager calendar;
	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	
	@BeforeEach
	void setUp() {
		Utilisateurs gestionUtilisateurs = new Utilisateurs();
		Utilisateur utilisateur = new Utilisateur("TestUser");
		calendar = new CalendarManager();
		ConnectedState state = new ConnectedState(utilisateur, gestionUtilisateurs, calendar);
		System.setOut(new PrintStream(outputStream));
	}
	
	@Test
	void testDetectConflictWhenAddingEvent() {
		// Ajout du premier événement
		EventId eventId1 = new EventId(1);
		TitreEvenement titre1 = new TitreEvenement("Réunion Projet");
		ProprietaireEvenement proprietaire1 = new ProprietaireEvenement("TestUser");
		DateDebutEvenement dateDebut1 = new DateDebutEvenement(LocalDateTime.of(2025, 5, 10, 14, 0));
		DureeMinutesEvenement duree1 = new DureeMinutesEvenement(60);
		LieuEvenement lieu1 = new LieuEvenement("Salle 101");
		ParticipantsEvenement participants1 = new ParticipantsEvenement(Collections.singletonList("Alice, Bob"));
		FrequenceJoursEvenement frequence1 = new FrequenceJoursEvenement(1);
		PresentateurEvenement presentateur1 = new PresentateurEvenement("Dr. Smith");
		
		Evenement e1 = new Evenement(eventId1, titre1, proprietaire1, dateDebut1, duree1, lieu1, participants1, frequence1, TypeEvenement.REUNION, presentateur1);
		
		calendar.ajouterEvenement(e1);
		
		// Ajout d'un deuxième événement qui chevauche le premier
		EventId eventId2 = new EventId(2);
		TitreEvenement titre2 = new TitreEvenement("Réunion Marketing");
		ProprietaireEvenement proprietaire2 = new ProprietaireEvenement("TestUser");
		DateDebutEvenement dateDebut2 = new DateDebutEvenement(LocalDateTime.of(2025, 5, 10, 14, 30)); // Chevauche à partir de 14:30
		DureeMinutesEvenement duree2 = new DureeMinutesEvenement(60);
		LieuEvenement lieu2 = new LieuEvenement("Salle 102");
		ParticipantsEvenement participants2 = new ParticipantsEvenement(Collections.singletonList("Charlie"));
		FrequenceJoursEvenement frequence2 = new FrequenceJoursEvenement(1);
		PresentateurEvenement presentateur2 = new PresentateurEvenement("Dr. Johnson");
		
		Evenement e2 = new Evenement(eventId1, titre1, proprietaire1, dateDebut1, duree1, lieu1, participants1, frequence1, TypeEvenement.REUNION, presentateur1);
		
		calendar.ajouterEvenement(e2);
		
		// Vérification de la sortie pour détecter un conflit
		String output = outputStream.toString();
		assertTrue(output.contains("Conflit avec l'événement suivant"));
		assertTrue(output.contains("Réunion Projet"));
		assertTrue(output.contains("Salle 101"));
	}
}
