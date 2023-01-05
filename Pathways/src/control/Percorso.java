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
		ArrayList<Edge> edge = new ArrayList<Edge>();
		ArrayList<Edge> edgeVisitati = new ArrayList<Edge>();
		Edge temp2 = null;
		Edge temp = null;
		Edge temp3 = null;
		boolean tempSettato = false;

		for (int i = 0; i < attrazioni.size(); i++) {
			temp2 = new Edge(null, null, Double.MAX_VALUE);
			if (attrazioni.indexOf(attrazioni.get(i)) != attrazioni.size() - 1) {

				for (int j = 0; j < attrazioni.size(); j++) {

					if (attrazioni.indexOf(attrazioni.get(j)) != attrazioni.size() - 1) {

						if (i > 0 && tempSettato == false) {
							temp = attrazioni.get(0).calcolaEdge(temp3.getDestinazione(),

									attrazioni.get(attrazioni.indexOf(temp3.getDestinazione()) + 1));
							tempSettato = true;

						} else {
							temp = attrazioni.get(0).calcolaEdge(attrazioni.get(i), attrazioni.get(j + 1));
						}
						if (temp.getPeso() < temp2.getPeso()) {
							temp2 = temp;

						}
					}
				}
				edge.add(temp2);
				tempSettato = false;
				temp3 = temp2.getDestinazione();
			}

		}
		System.out.println(edge);
		response.setCharacterEncoding("UTF-8");

	}

}
