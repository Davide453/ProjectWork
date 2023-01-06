package model;

public class Edge {

	private AttrazioneNodo origine;
	private AttrazioneNodo destinazione;
	private double peso;

	public Edge(AttrazioneNodo origine, AttrazioneNodo destinazione, double peso) {
		this.origine = origine;
		this.destinazione = destinazione;
		this.peso = peso;
	}

	public AttrazioneNodo getOrigine() {
		return origine;
	}

	public void setOrigine(AttrazioneNodo origine) {
		this.origine = origine;
	}

	public AttrazioneNodo getDestinazione() {
		return destinazione;
	}

	public void setDestinazione(AttrazioneNodo destinazione) {
		this.destinazione = destinazione;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Origine: " + origine + " Destinazione: " + destinazione + " Peso: " + peso + " Km \n"
				+ "----------------------------------------------------------------------------" + "\n";
	}

	// FUNZIONE CHE RITORNA LA DISTANZA FRA DUE PUNTI DANDOGLI UN ORIGINE ED UNA DESTINAZIONE
	public static Edge calcolaEdge(AttrazioneNodo origine, AttrazioneNodo destinazione) {
		double lat1 = Math.toRadians(origine.getLat());
		double lon1 = Math.toRadians(origine.getLng());
		double lat2 = Math.toRadians(destinazione.getLat());
		double lon2 = Math.toRadians(destinazione.getLng());

		double dlon = lon2 - lon1;
		double dlat = lat2 - lat1;

		double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);

		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		double R = 6371; // raggio della Terra in chilometri
		double peso = R * c;

		Edge edge = new Edge(origine, destinazione, peso);

		return edge;
	}
	
}
