package model;

import java.util.ArrayList;

public class Percorso {

	private String nome;
	private int idPercorso;
	private int idUtente;
	private ArrayList<AttrazioneNodo> ordineNodi;

	public Percorso() {

	}

	public Percorso(String nome, int idPercorso, int idUtente, ArrayList<Edge> edgeArray) {
		this.nome = nome;
		this.idPercorso = idPercorso;
		this.idUtente = idUtente;
		this.ordineNodi = calcolaOrdineNodi(edgeArray);
	}

	public Percorso(String nome, ArrayList<Edge> edgeArray) {
		this.nome = nome;
		this.ordineNodi = calcolaOrdineNodi(edgeArray);
	}

	public ArrayList<AttrazioneNodo> calcolaOrdineNodi(ArrayList<Edge> edgeArray) {
		ArrayList<AttrazioneNodo> tempOrdine = new ArrayList<AttrazioneNodo>();
		int counter = 0;
		for (Edge e : edgeArray) {
			System.out.println(counter);
			e.getOrigine().setOrdine(counter);
			tempOrdine.add(e.getOrigine());
			if (edgeArray.indexOf(e) == edgeArray.size()) {
				e.getDestinazione().setOrdine(counter);
				tempOrdine.add(e.getDestinazione());
			}
			counter++;
		}
		System.out.println("tempordine: " + tempOrdine);
		return tempOrdine;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setIdPercorso(int idPercorso) {
		this.idPercorso = idPercorso;
	}

	public int getIdPercorso() {
		return idPercorso;
	}

	public ArrayList<AttrazioneNodo> getOrdineNodi() {
		return ordineNodi;
	}

	public void setOrdineNodi(ArrayList<AttrazioneNodo> ordineNodi) {
		this.ordineNodi = ordineNodi;
	}

	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	@Override
	public String toString() {
		return "Percorso [nome=" + nome + ", idPercorso=" + idPercorso + ", ordineNodi=" + ordineNodi + "]";
	}

}
