package model;

import model.testDijkstra.Node;

public class AttrazioneNodo {

	private String id;
	private String nomeAttrazione;

	private String viaAttrazione;

	private double lat;
	private double lng;

	public AttrazioneNodo(String id, String nomeAttrazione, String viaAttrazione, double lat, double lng) {

		this.id = id;
		this.nomeAttrazione = nomeAttrazione;
		this.viaAttrazione = viaAttrazione;
		this.lat = lat;
		this.lng = lng;
	}

	public String getNomeAttrazione() {
		return nomeAttrazione;
	}

	public void setNomeAttrazione(String nomeAttrazione) {
		this.nomeAttrazione = nomeAttrazione;
	}

	public String getViaAttrazione() {
		return viaAttrazione;
	}

	public void setViaAttrazione(String viaAttrazione) {
		this.viaAttrazione = viaAttrazione;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return " AttrazioneNodo [id=" + id + ", nomeAttrazione=" + nomeAttrazione + ", viaAttrazione=" + viaAttrazione
				+ ", lat=" + lat + ", lng=" + lng + "] \n";
	}

	public Edge calcolaEdge(AttrazioneNodo origine, AttrazioneNodo destinazione) {
		double lat1 = Math.toRadians(origine.lat);
		double lon1 = Math.toRadians(origine.lng);
		double lat2 = Math.toRadians(destinazione.lat);
		double lon2 = Math.toRadians(destinazione.lng);

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