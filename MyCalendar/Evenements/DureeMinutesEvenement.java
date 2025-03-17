package Evenements;

public class DureeMinutesEvenement {
	private final int dureeMinutes;
	
	public DureeMinutesEvenement(int dureeMinutes) {
		if (dureeMinutes <= 0) {
			throw new IllegalArgumentException("La durée doit être supérieure à zéro.");
		}
		this.dureeMinutes = dureeMinutes;
	}
	
	public int getDureeMinutes() {
		return dureeMinutes;
	}
	
	@Override
	public String toString() {
		return String.valueOf(dureeMinutes);
	}
}

