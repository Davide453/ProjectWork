package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Set;

import model.Node;

public class Node {

	private String id;
	private String nomeAttrazione;
	private String viaAttrazione;

	private double lat;
	private double lng;

	public Node(String id, String nomeAttrazione, String viaAttrazione, double lat, double lng) {

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

	public void setId(String id) {
		this.id = id;
	}

	public static List<Node> nodiAttrazioni(StringBuilder sb) {

		List<Node> attrazioni = new ArrayList<Node>();

		JsonArray data = (JsonArray) new JsonParser().parse(sb.toString());
		for (int i = 0; i < data.size(); i++) {
			JsonObject jsonObject = data.get(i).getAsJsonObject();

			JsonElement nameElement = jsonObject.get("name"); // OTTENGO L'ELEMENTO name DALL'OGGETTO jsonObject data

			JsonObject geometryObject = (JsonObject) jsonObject.get("geometry"); // OTTENGO L'OGGETTO geometry
																					// DALL'OGGETTO jsonObject data

			JsonObject geometryObject2 = geometryObject.get("location").getAsJsonObject(); // OTTENGO L'OGGETTO location
																							// DALL'OGGETTO jsonObject
																							// geometry

			JsonElement latElement = geometryObject2.get("lat"); // OTTENGO L'ELEMENTO latitudine DALL'OGGETTO
																	// jsonObject geometry

			JsonElement lngElement = geometryObject2.get("lng"); // OTTENGO L'ELEMENTO longitudine DALL'OGGETTO
																	// jsonObject geometry

			JsonElement placeId = jsonObject.get("place_id"); // OTTENGO L'ELEMENTO place_id DALL'OGGETTO jsonObject
																// data

			JsonElement vicinityElement = jsonObject.get("vicinity"); // OTTENGO L'ELEMENTO vicinity DALL'OGGETTO
																		// jsonObject data

			Node nodo = new Node(placeId.getAsString(), nameElement.getAsString(), vicinityElement.getAsString(),
					latElement.getAsDouble(), lngElement.getAsDouble()); // CREO UN NUOVO NODO ATTRAZIONE
																			// CON TUTTI I
																			// PARAMETRI CHE
																			// HO OTTENUTO

			attrazioni.add(nodo); // AGGIUNGO QUESTE ATTRAZIONI AD UN'ARRAYLIST DI ATTRAZIONI
		}
		return attrazioni;
	}
	

	@Override
	public String toString() {
		return "Nome: " + nomeAttrazione + "\n";
	}
	

}