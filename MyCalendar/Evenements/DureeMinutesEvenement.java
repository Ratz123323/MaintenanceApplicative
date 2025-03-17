package Evenements;

public record DureeMinutesEvenement(int dureeMinutes) {
	public DureeMinutesEvenement {
		if (dureeMinutes <= 0) {
			throw new IllegalArgumentException("La durée (minutes) doit être supérieure à zéro.");
		}
	}
	
	@Override
	public String toString() {
		return String.valueOf(dureeMinutes);
	}
}

