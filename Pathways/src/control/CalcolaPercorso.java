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
import javax.servlet.http.HttpSession;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import data.PercorsoDAO;
import model.AttrazioneNodo;
import model.Edge;
import model.Percorso;
import model.User;

@WebServlet("/update")
public class CalcolaPercorso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CalcolaPercorso() {
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
		HttpSession session = request.getSession(true);
		Boolean loggato = (Boolean) session.getAttribute("loggato");
		if (loggato != null && loggato == true) {
			
		}
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

		// System.out.println(attrazioni);

		ArrayList<Edge> percorso = new ArrayList<Edge>();

		ArrayList<AttrazioneNodo> nodiDaCalcolare = new ArrayList<AttrazioneNodo>();

		for (int i = 1; i < attrazioni.size(); i++) {
			nodiDaCalcolare.add(attrazioni.get(i));
		}

		Edge edgeBest = null;
		Edge edgeNew = null;

		int k = 0;
		while (attrazioni.size() - 1 != percorso.size()) {

			edgeBest = new Edge(null, null, Double.MAX_VALUE);

			for (AttrazioneNodo destinazione : nodiDaCalcolare) {

				edgeNew = attrazioni.get(0).calcolaEdge(attrazioni.get(k), destinazione);

				if (edgeNew.getPeso() < edgeBest.getPeso()) {
					edgeBest = edgeNew;
				}
			}
			percorso.add(edgeBest);

			k = attrazioni.indexOf(edgeBest.getDestinazione());

			nodiDaCalcolare.remove(edgeBest.getOrigine());
			nodiDaCalcolare.remove(edgeBest.getDestinazione());

		}

		User user = (User) session.getAttribute("user");
		Percorso percorso2 = new Percorso("attrazioni", percorso);

		PercorsoDAO.insertPercorso(percorso2, user);
		response.setCharacterEncoding("UTF-8");

	}

}
