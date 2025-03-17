package Evenements;

import java.util.List;

public record ParticipantsEvenement(List<String> participants) {
	
	@Override
	public String toString() {
		return String.join(", ", participants);
	}
}

