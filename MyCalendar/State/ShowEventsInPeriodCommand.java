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
		System.out.print("Année de début (AAAA) : ");
		int anneeDebut = Integer.parseInt(scanner.nextLine());
		System.out.print("Mois de début (1-12) : ");
		int moisDebut = Integer.parseInt(scanner.nextLine());
		System.out.print("Jour de début (1-31) : ");
		int jourDebut = Integer.parseInt(scanner.nextLine());
		System.out.print("Heure de début (0-23) : ");
		int heureDebut = Integer.parseInt(scanner.nextLine());
		System.out.print("Minute de début (0-59) : ");
		int minuteDebut = Integer.parseInt(scanner.nextLine());
		
		System.out.print("Année de fin (AAAA) : ");
		int anneeFin = Integer.parseInt(scanner.nextLine());
		System.out.print("Mois de fin (1-12) : ");
		int moisFin = Integer.parseInt(scanner.nextLine());
		System.out.print("Jour de fin (1-31) : ");
		int jourFin = Integer.parseInt(scanner.nextLine());
		System.out.print("Heure de fin (0-23) : ");
		int heureFin = Integer.parseInt(scanner.nextLine());
		System.out.print("Minute de fin (0-59) : ");
		int minuteFin = Integer.parseInt(scanner.nextLine());
		
		LocalDateTime dateDebutPeriode = LocalDateTime.of(anneeDebut, moisDebut, jourDebut, heureDebut, minuteDebut);
		LocalDateTime dateFinPeriode = LocalDateTime.of(anneeFin, moisFin, jourFin, heureFin, minuteFin);
		
		state.getCalendar().obtenirEvenementsDansPeriode(dateDebutPeriode, dateFinPeriode);
		return state;
	}
}
