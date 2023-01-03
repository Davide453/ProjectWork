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

import model.AttrazioneNodo;

@WebServlet("/GetPercorso")
public class Percorso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Percorso() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Legge il corpo della richiesta come stringa
		BufferedReader reader = request.getReader();
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		String jsonString = sb.toString();

		// Converti l'oggetto JSON in un array di nodi Java
		Gson gson = new Gson();
		AttrazioneNodo[] nodes = gson.fromJson(jsonString, AttrazioneNodo[].class);
		
		System.out.println();

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
