package Evenements;

public class LieuEvenement {
	private final String lieu;
	
	public LieuEvenement(String lieu) {
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

