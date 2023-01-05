package control;

import java.io.BufferedReader;

import java.io.IOException;
import java.util.ArrayList;

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

			JsonElement nameElement = jsonObject.get("name");

			JsonObject geometryObject = (JsonObject) jsonObject.get("geometry");

			JsonObject geometryObject2 = geometryObject.get("location").getAsJsonObject();

			JsonElement latElement = geometryObject2.get("lat");

			JsonElement lngElement = geometryObject2.get("lng");

			JsonElement placeId = jsonObject.get("place_id");

			JsonElement vicinityElement = jsonObject.get("vicinity");

			AttrazioneNodo nodo = new AttrazioneNodo(placeId.getAsString(), nameElement.getAsString(),
					vicinityElement.getAsString(), latElement.getAsDouble(), lngElement.getAsDouble());

			attrazioni.add(nodo);
		}

		System.out.println(attrazioni);
		ArrayList<Edge> nodiVisitati = new ArrayList<Edge>();
		ArrayList<AttrazioneNodo> nodiDaVisitare = new ArrayList<AttrazioneNodo>();

		for (int i = 0; i < attrazioni.size(); i++) {

			nodiDaVisitare.add(attrazioni.get(i));
		}

		Edge edgeTemporaneo2 = null;
		Edge edgeTemporaneo1 = null;

		AttrazioneNodo origine = null;
		AttrazioneNodo destinazione = null;

		boolean percorso = false;

		for (int i = 0; i < attrazioni.size(); i++) {
			edgeTemporaneo2 = new Edge(null, null, Double.MAX_VALUE);

			if (attrazioni.indexOf(attrazioni.get(i)) != attrazioni.size() - 1) {

				for (int j = 0; j < attrazioni.size(); j++) {

					if (nodiDaVisitare.size() != attrazioni.size() - 1) {

						if (i == 0) {

							edgeTemporaneo1 = attrazioni.get(0).calcolaEdge(attrazioni.get(i),
									nodiDaVisitare.get(j + 1));

						} else {
							destinazione = nodiDaVisitare.get(j + 1);

							edgeTemporaneo1 = attrazioni.get(0).calcolaEdge(origine, destinazione);

						}

						if (edgeTemporaneo1.getPeso() < edgeTemporaneo2.getPeso()) {
							edgeTemporaneo2 = edgeTemporaneo1;

						}
					}
				}

				nodiVisitati.add(edgeTemporaneo2);

				origine = edgeTemporaneo2.getDestinazione();

				nodiDaVisitare.remove(edgeTemporaneo2.getOrigine());

			}

		}

		System.out.println(nodiVisitati);
		response.setCharacterEncoding("UTF-8");

	}

}
