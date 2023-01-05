package control;

import java.io.BufferedReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.AttrazioneNodo;
import model.Edge;
import model.EdgeComparator;

@WebServlet("/update")
public class Percorso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Percorso() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Legge il corpo della richiesta come stringa
		BufferedReader reader = request.getReader();
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line);

		}

		ArrayList<AttrazioneNodo> attrazioni = new ArrayList<AttrazioneNodo>();

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
					vicinityElement.getAsString(), latElement.getAsDouble(), lngElement.getAsDouble()); // CREO UN NUOVO
																										// NODO
																										// ATTRAZIONE
																										// CON TUTTI I
																										// PARAMETRI CHE
																										// HO OTTENUTO

			attrazioni.add(nodo); // AGGIUNGO QUESTE ATTRAZIONI AD UN'ARRAYLIST DI ATTRAZIONI
		}

		response.setCharacterEncoding("UTF-8");

		Map<Integer, Edge> itinerario = new HashMap<Integer, Edge>();

		int contatore = 0;

		Edge percorsoPiuCorto = percorsoPiuCortoDaOrigine(attrazioni);

		System.out.println("Il percorso più corto partendo da\n" + attrazioni.get(0) + " è\n" + percorsoPiuCorto);
		
		
		
//		itinerario.put(contatore, percorsoPiuCorto);
//		contatore++;
//		
//		System.out.println(getPartenzaIndex(attrazioni, percorsoPiuCorto));
//		
//		System.out.println("Il tuo itinerario è " + itinerario);

	}

	// FUNZIONE PER OTTENERE L'INDICE DI PARTENZA DEL PERCORSO PIU BREVE
	public int getPartenzaIndex(List<AttrazioneNodo> attrazioni, Edge percorsoPiuCorto) {
		int index = attrazioni.indexOf(percorsoPiuCorto.getDestinazione());
		return index;
	}

	public Edge percorsoPiuCortoDaOrigine(List<AttrazioneNodo> attrazioni) {
		
		Edge percorsoPiuCorto = new Edge(null, null, Integer.MAX_VALUE);
		int origine = 0;
		for (int i = 1; i < attrazioni.size(); i++) {
			Edge percorsoPiuCorto2 = calcolaPercorso(attrazioni, origine, i);
			System.out.println(percorsoPiuCorto2);
			if (percorsoPiuCorto2.getPeso() < percorsoPiuCorto.getPeso()) {
				percorsoPiuCorto = percorsoPiuCorto2;
			}
		}
		return percorsoPiuCorto;
	}

	// CALCOLA L'EDGE DI UN PERCORSO
	public Edge calcolaPercorso(List<AttrazioneNodo> attrazioni, int partenza, int destinazione) {

		Edge percorso = attrazioni.get(destinazione).calcolaEdge(attrazioni.get(partenza),
				attrazioni.get(destinazione));

		return percorso;
	}

	// ORDINO I PERCORSI IN MODO CRESCENTE
	public List<Edge> ordinaPercorsi(List<Edge> percorsi) {

		Collections.sort(percorsi, new EdgeComparator()); // ORDINO I PERCORSI IN MODO CRESCENTE

		return percorsi;
	}

}
