package model;

import java.util.HashSet;
import java.util.Set;

public class Grafo {

	private Set<AttrazioneNodo> attrazioni = new HashSet<>();

	public void addNode(AttrazioneNodo nodeA) {
		attrazioni.add(nodeA);
	}

	public Set<AttrazioneNodo> getAttrazioni() {
		return attrazioni;
	}

	public void setAttrazioni(Set<AttrazioneNodo> attrazioni) {
		this.attrazioni = attrazioni;
	}

	
}
