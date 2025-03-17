package Evenements;

public class FrequenceJoursEvenement {
	private final int frequenceJours;
	
	public FrequenceJoursEvenement(int frequenceJours) {
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

