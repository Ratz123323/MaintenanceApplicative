package Evenements;

public record FrequenceJoursEvenement(int frequenceJours) {
	
	@Override
	public String toString() {
		return String.valueOf(frequenceJours);
	}
}

