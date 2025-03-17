package Evenements;

public class LieuEvenement {
	private final String lieu;
	
	public LieuEvenement(String lieu) {
		if (lieu == null || lieu.isEmpty()) {
			throw new IllegalArgumentException("Le lieu ne peut pas être vide");
		}
		this.lieu = lieu;
	}
	
	public String getLieu() {
		return lieu;
	}
	
	@Override
	public String toString() {
		return lieu;
	}
}

