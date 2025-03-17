package Evenements;

import java.time.LocalDateTime;

public class DateDebutEvenement {
	private final LocalDateTime dateDebut;
	
	public DateDebutEvenement(LocalDateTime dateDebut) {
		if (dateDebut == null) {
			throw new IllegalArgumentException("La date de début ne peut pas être nulle.");
		}
		this.dateDebut = dateDebut;
	}
	
	public LocalDateTime getDateDebut() {
		return dateDebut;
	}
	
	@Override
	public String toString() {
		return dateDebut.toString();
	}
}

