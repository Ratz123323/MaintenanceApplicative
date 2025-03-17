package Evenements;

public class FrequenceJoursEvenement {
	private final int frequenceJours;
	
	public FrequenceJoursEvenement(int frequenceJours) {
		if (frequenceJours <= 0) {
			throw new IllegalArgumentException("La fréquence doit être supérieure à 0.");
		}
		this.frequenceJours = frequenceJours;
	}
	
	public int getFrequenceJours() {
		return frequenceJours;
	}
	
	@Override
	public String toString() {
		return String.valueOf(frequenceJours);
	}
}

