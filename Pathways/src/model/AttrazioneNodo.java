package model;

public class AttrazioneNodo extends Nodo {

	private String nomeAttrazione;
	private String recensione;
	private String viaAttrazione;
	private Nodo nodo;
	
	
	public AttrazioneNodo(Nodo nodo, String nomeAttrazione, String recensione, String viaAttrazione) {
		
		this.nodo = nodo;
		this.nomeAttrazione = nomeAttrazione;
		this.recensione = recensione;
		this.viaAttrazione = viaAttrazione;
				
		
	}


	public String getNomeAttrazione() {
		return nomeAttrazione;
	}


	public void setNomeAttrazione(String nomeAttrazione) {
		this.nomeAttrazione = nomeAttrazione;
	}


	public String getRecensione() {
		return recensione;
	}


	public void setRecensione(String recensione) {
		this.recensione = recensione;
	}


	public String getViaAttrazione() {
		return viaAttrazione;
	}


	public void setViaAttrazione(String viaAttrazione) {
		this.viaAttrazione = viaAttrazione;
	}


	public Nodo getNodo() {
		return nodo;
	}


	public void setNodo(Nodo nodo) {
		this.nodo = nodo;
	}

	@Override
	public String toString() {
		return "AttrazioneNodo [nomeAttrazione=" + nomeAttrazione + ", recensione=" + recensione + ", viaAttrazione="
				+ viaAttrazione + ", nodo=" + nodo + "]";
	}
	
	
	
}
