package State;

import Evenements.*;
import Evenements.TypeEvenements.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Scanner;

public class AddPeriodicCommand implements AppStateCommand {
	
	private final ConnectedState state;
	
	public AddPeriodicCommand(ConnectedState state) {
		this.state = state;
	}
	
	public AppState execute(Scanner scanner) {
		System.out.print("Titre de l'événement : ");
		String titre = scanner.nextLine();
		System.out.print("Année (AAAA) : ");
		int annee = Integer.parseInt(scanner.nextLine());
		System.out.print("Mois (1-12) : ");
		int mois = Integer.parseInt(scanner.nextLine());
		System.out.print("Jour (1-31) : ");
		int jour = Integer.parseInt(scanner.nextLine());
		System.out.print("Heure début (0-23) : ");
		int heure = Integer.parseInt(scanner.nextLine());
		System.out.print("Minute début (0-59) : ");
		int minute = Integer.parseInt(scanner.nextLine());
		System.out.print("Fréquence (en jours) : ");
		int frequence = Integer.parseInt(scanner.nextLine());
		System.out.print("Lieu : ");
		String lieu = scanner.nextLine();
		TitreEvenement titreEvenement = new TitreEvenement(titre);
		ProprietaireEvenement proprietaireEvenement = new ProprietaireEvenement(state.getUtilisateur().nom());
		DateDebutEvenement dateDebutEvenement = new DateDebutEvenement(LocalDateTime.of(annee, mois, jour, heure, minute));
		DureeMinutesEvenement dureeMinutesEvenement = new DureeMinutesEvenement(1); // valeur par défaut minimale
		LieuEvenement lieuEvenement = new LieuEvenement(lieu);
		ParticipantsEvenement participantsEvenement = new ParticipantsEvenement(Collections.singletonList(""));
		FrequenceJoursEvenement frequenceJoursEvenement = new FrequenceJoursEvenement(frequence);
		TypeEvenement typeEvenement = TypeEvenement.PERIODIQUE;
		state.getCalendar().ajouterEvenement(titreEvenement, proprietaireEvenement, dateDebutEvenement, dureeMinutesEvenement, lieuEvenement, participantsEvenement, frequenceJoursEvenement, typeEvenement);
		System.out.println("Événement périodique ajouté.");
		return state;
	}
}
