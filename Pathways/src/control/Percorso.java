package control;

import java.io.BufferedReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

		Gson g = new Gson();
		System.out.println("g.tojson(sb)" + g.toJson(sb));

		String test = g.toJson(sb);
		System.out.println(test);

		JsonArray data = (JsonArray) new JsonParser().parse(sb.toString());

		System.out.println(data);

		System.out.println(data.get(0));
		// JsonObject jsonObject = data.get(0);

		for (int i = 0; i < data.size(); i++) {
			JsonObject jsonObject = data.get(i).getAsJsonObject();

			JsonElement nameElement = jsonObject.get("name");

			JsonObject geometryObject = (JsonObject) jsonObject.get("geometry");

			JsonElement geometryElement = geometryObject.get("location");

			JsonElement namePlaceId = jsonObject.get("place_id");

			JsonElement vicinityElement = jsonObject.get("vicinity");

			System.out.println(nameElement);
			System.out.println(geometryElement);
			System.out.println(namePlaceId);
			System.out.println(vicinityElement);
			
		}

		response.setCharacterEncoding("UTF-8");

	}

}
