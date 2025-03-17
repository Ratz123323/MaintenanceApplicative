package Evenements;

import java.time.LocalDateTime;

public record DateDebutEvenement(LocalDateTime dateDebut) {
	public DateDebutEvenement {
		if (dateDebut == null) {
			throw new IllegalArgumentException("La date de début ne peut pas être nulle.");
		}
	}
	
	@Override
	public String toString() {
		return dateDebut.toString();
	}
}

