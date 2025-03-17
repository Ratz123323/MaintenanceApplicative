package Evenements;

public record LieuEvenement(String lieu) {
	
	@Override
	public String toString() {
		return lieu;
	}
}

