import Evenements.*;
import Evenements.TypeEvenements.TypeEvenement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.Collections;

public class EventRecordsTest {
	
	@Test
	public void testDateDebutEvenement() {
		LocalDateTime now = LocalDateTime.now();
		DateDebutEvenement dateDebut = new DateDebutEvenement(now);
		assertEquals(now, dateDebut.dateDebut());
		assertThrows(IllegalArgumentException.class, () -> new DateDebutEvenement(null));
		LocalDateTime futureDate = LocalDateTime.of(2025, 12, 31, 12, 0, 0, 0);
		DateDebutEvenement futureEvent = new DateDebutEvenement(futureDate);
		assertEquals(futureDate, futureEvent.dateDebut());
	}
	
	@Test
	public void testDureeMinutesEvenement() {
		DureeMinutesEvenement duree = new DureeMinutesEvenement(120);
		assertEquals(120, duree.dureeMinutes());
		assertThrows(IllegalArgumentException.class, () -> new DureeMinutesEvenement(-5));
		assertThrows(IllegalArgumentException.class, () -> new DureeMinutesEvenement(0));
		DureeMinutesEvenement oneDuration = new DureeMinutesEvenement(1);
		assertEquals(1, oneDuration.dureeMinutes());
	}
	
	@Test
	public void testFrequenceJoursEvenement() {
		FrequenceJoursEvenement frequence = new FrequenceJoursEvenement(30);
		assertEquals(30, frequence.frequenceJours());
		FrequenceJoursEvenement oneDayFrequency = new FrequenceJoursEvenement(1);
		assertEquals(1, oneDayFrequency.frequenceJours());
	}
	
	@Test
	public void testLieuEvenement() {
		LieuEvenement lieu = new LieuEvenement("Salle de réunion A");
		assertEquals("Salle de réunion A", lieu.lieu());
		LieuEvenement lieuVide = new LieuEvenement("");
		assertEquals("", lieuVide.lieu());
	}
	
	@Test
	public void testParticipantsEvenement() {
		ParticipantsEvenement participants = new ParticipantsEvenement(Collections.singletonList("Alice, Bob"));
		assertEquals("Alice, Bob", participants.toString());
	}
	
	@Test
	public void testProprietaireEvenement() {
		ProprietaireEvenement proprietaire = new ProprietaireEvenement("Roger");
		assertEquals("Roger", proprietaire.proprietaire());
		assertThrows(IllegalArgumentException.class, () -> new ProprietaireEvenement(null));
		assertThrows(IllegalArgumentException.class, () -> new ProprietaireEvenement(""));
		ProprietaireEvenement validProprietaire = new ProprietaireEvenement("Pierre");
		assertEquals("Pierre", validProprietaire.proprietaire());
	}

	
	@Test
	public void testTitreEvenement() {
		TitreEvenement titre = new TitreEvenement("Réunion stratégique");
		assertEquals("Réunion stratégique", titre.titre());
		assertThrows(IllegalArgumentException.class, () -> new TitreEvenement(null));
		assertThrows(IllegalArgumentException.class, () -> new TitreEvenement(""));
		assertThrows(IllegalArgumentException.class, () -> new TitreEvenement("AB"));
		TitreEvenement validTitre = new TitreEvenement("ABC");
		assertEquals("ABC", validTitre.titre());
	}

	
	@Test
	public void testToString() {
		LocalDateTime now = LocalDateTime.now();
		DateDebutEvenement dateDebut = new DateDebutEvenement(now);
		DureeMinutesEvenement duree = new DureeMinutesEvenement(60);
		FrequenceJoursEvenement frequence = new FrequenceJoursEvenement(7);
		LieuEvenement lieu = new LieuEvenement("Salle de conférence");
		ParticipantsEvenement participants = new ParticipantsEvenement(Collections.singletonList("Alice, Bob"));
		ProprietaireEvenement proprietaire = new ProprietaireEvenement("Roger");
		TitreEvenement titre = new TitreEvenement("Réunion stratégique");
		Evenement event = new Evenement(titre, proprietaire, dateDebut, duree, lieu, participants, frequence, TypeEvenement.REUNION, new PresentateurEvenement(""));
		String description = event.toString();
		assertTrue(description.contains("Réunion : Réunion stratégique à Salle de conférence avec Alice, Bob"));
	}
	
	@Test
	public void testEventType() {
		LocalDateTime now = LocalDateTime.now();
		DateDebutEvenement dateDebut = new DateDebutEvenement(now);
		DureeMinutesEvenement duree = new DureeMinutesEvenement(60);
		FrequenceJoursEvenement frequence = new FrequenceJoursEvenement(7);
		LieuEvenement lieu = new LieuEvenement("Salle de réunion");
		ParticipantsEvenement participants = new ParticipantsEvenement(Collections.singletonList("Alice, Bob"));
		ProprietaireEvenement proprietaire = new ProprietaireEvenement("Roger");
		TitreEvenement titre = new TitreEvenement("Réunion stratégique");
		Evenement eventRdv = new Evenement(titre, proprietaire, dateDebut, duree, lieu, participants, frequence, TypeEvenement.RDV_PERSONNEL, new PresentateurEvenement(""));
		Evenement eventReunion = new Evenement(titre, proprietaire, dateDebut, duree, lieu, participants, frequence, TypeEvenement.REUNION, new PresentateurEvenement(""));
		Evenement eventPeriodique = new Evenement(titre, proprietaire, dateDebut, duree, lieu, participants, frequence, TypeEvenement.PERIODIQUE, new PresentateurEvenement(""));
		assertTrue(eventRdv.toString().contains("RDV"));
		assertTrue(eventReunion.toString().contains("Réunion"));
		assertTrue(eventPeriodique.toString().contains("Événement périodique"));
	}
	
	@Test
	public void testNullTitre() {
		assertThrows(IllegalArgumentException.class, () -> new TitreEvenement(null));
	}
	
	@Test
	public void testNullProprietaire() {
		assertThrows(IllegalArgumentException.class, () -> new ProprietaireEvenement(null));
	}
	
	@Test
	public void testNullDateDebut() {
		assertThrows(IllegalArgumentException.class, () -> new DateDebutEvenement(null));
	}
	
	@Test
	public void testZeroDureeMinutes() {
		assertThrows(IllegalArgumentException.class, () -> new DureeMinutesEvenement(0));
	}
}
