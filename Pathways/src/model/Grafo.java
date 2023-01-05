package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Grafo {
	
	public List<AttrazioneNodo> nodiAttrazioni(StringBuilder sb) {
		
		List<AttrazioneNodo> attrazioni = new ArrayList<AttrazioneNodo>();
		
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

			AttrazioneNodo nodo = new AttrazioneNodo(placeId.getAsString(), nameElement.getAsString(),
					vicinityElement.getAsString(), latElement.getAsDouble(), lngElement.getAsDouble()); // CREO UN NUOVO NODO ATTRAZIONE
																										// CON TUTTI I
																										// PARAMETRI CHE
																										// HO OTTENUTO

			attrazioni.add(nodo); // AGGIUNGO QUESTE ATTRAZIONI AD UN'ARRAYLIST DI ATTRAZIONI
		}
		return attrazioni;
	}
	
}
