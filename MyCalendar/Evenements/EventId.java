package Evenements;

import org.w3c.dom.ls.LSOutput;

public record EventId(int id) {
	public EventId {
		if (id < 0) {
			throw new IllegalArgumentException("EventId invalide");
		}
	}
	
	public EventId increment(){
		return new EventId(id + 1);
	}
	
	@Override
	public String toString() {
		return Integer.toString(id);
	}
}
