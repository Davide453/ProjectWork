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
		return "Origine: " + origine + " Destinazione: " + destinazione + " Peso: " + peso + " Km \n" + "----------------------------------------------------------------------------" + "\n";
	}
	
	
}
