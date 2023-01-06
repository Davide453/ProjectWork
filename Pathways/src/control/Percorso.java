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
		response.setCharacterEncoding("UTF-8");

		List<Node> nodiNonVisitati = Node.nodiAttrazioni(sb);

		List<Edge> percorsiFatti = new ArrayList<Edge>();
		percorsiFatti = percorsiFattiPiuCorti(nodiNonVisitati);
		System.out.println(percorsiFatti);

		System.out.println(itinerario(percorsiFatti));

	}

	public Edge getOrigin(List<Edge> percorsiFatti) {
		Edge origine = percorsiFatti.get(0);
		return origine;
	}

	// FUNZIONE CHE RITORNA UN HASHMAP ITINERARIO CON TUTTI I PERCORSI ORDINATI
	public Map<Integer, Edge> itinerario(List<Edge> percorsiFatti) {
		Map<Integer, Edge> itinerario = new HashMap<Integer, Edge>();
		List<Edge> percorsiFattiTemp = new ArrayList<Edge>();

		for (Edge e : percorsiFatti) {
			percorsiFattiTemp.add(e);
		}

		Edge origin = getOrigin(percorsiFattiTemp);

		itinerario.put(0, origin); // INSERISCO IL PERCORSO N 1

		percorsiFattiTemp.remove(0);

		Node currentOrigin = origin.getDestinazione();
		int i = 1;
		while (i < percorsiFatti.size() - 1) {
			Edge nextEdge = findNextEdge(currentOrigin, percorsiFatti);
			if (nextEdge == null) {
				break;
			}
			itinerario.put(i, nextEdge);
			currentOrigin = nextEdge.getDestinazione();
			percorsiFattiTemp.remove(nextEdge);
			i++;
		}

		Edge ultimoPercorso = new Edge(percorsiFattiTemp.get(0).getDestinazione(),
				percorsiFattiTemp.get(0).getOrigine(), percorsiFattiTemp.get(0).getPeso());

		itinerario.put(itinerario.size(), ultimoPercorso);

		return itinerario;
	}

	private Edge findNextEdge(Node origin, List<Edge> edges) {
		for (Edge edge : edges) {
			if (edge.getOrigine() == origin) {
				return edge;
			}
		}
		return null;
	}

	
	// PRENDO UNA LISTA DI NODI NON VISITATI E CALCOLO LA DISTANZA PER OGNUNO DI
		// ESSI E RITORNO UNA LISTA CON I NODI VISITATI
		public List<Edge> percorsiPiuCorti(List<Node> nodi) {
			List<Edge> percorsiFatti = new ArrayList<Edge>();
			List<Edge> percorsiTempFatti = new ArrayList<Edge>();
			for (int j = 0; j < nodi.size(); j++) {
				for (int i = 1; i < nodi.size(); i++) {
					if (Edge.calcolaEdge(nodi.get(j), nodi.get(i)).getPeso() != 0) {
						percorsiTempFatti.add(Edge.calcolaEdge(nodi.get(j), nodi.get(i)));
					} else {
						i++;
					}

				}
				ordinaPercorsi(percorsiTempFatti);

				percorsiFatti.add(percorsiTempFatti.get(0));

				
				percorsiTempFatti.clear();

			}

			return percorsiFatti;
		}
	
	// PRENDO UNA LISTA DI NODI NON VISITATI E CALCOLO LA DISTANZA PER OGNUNO DI
	// ESSI E RITORNO UNA LISTA CON I NODI VISITATI
	public List<Edge> percorsiFattiPiuCorti(List<Node> nodi) {
		List<Edge> percorsiFatti = new ArrayList<Edge>();
		List<Edge> percorsiTempFatti = new ArrayList<Edge>();
		for (int j = 0; j < nodi.size(); j++) {
			for (int i = 1; i < nodi.size(); i++) {
				if (Edge.calcolaEdge(nodi.get(j), nodi.get(i)).getPeso() != 0) {
					percorsiTempFatti.add(Edge.calcolaEdge(nodi.get(j), nodi.get(i)));
				} else {
					i++;
				}

			}
			ordinaPercorsi(percorsiTempFatti);
						
			if(isPresente(percorsiTempFatti, percorsiFatti) == true) {
				percorsiFatti.add(percorsiTempFatti.get(j+1));
			} else {
				percorsiFatti.add(percorsiTempFatti.get(0));
			}
			
			percorsiTempFatti.clear();

		}

		return percorsiFatti;
	}
	
	public boolean isPresente(List<Edge> percorsiTemp, List<Edge> percorsiFatti) {
		boolean presente = false;
		for(Edge e : percorsiTemp) {
			if(percorsiFatti.contains(e)) {
				presente = true;
			}
		}
		return presente;
	}

	public List<Edge> ordinaPercorsi(List<Edge> percorsi) {

		Collections.sort(percorsi, new EdgeComparator()); // ORDINO I PERCORSI IN MODO CRESCENTE

		return percorsi;
	}

	/*
	 * 
	 * // FUNZIONE CHE RITORNA UN HASHMAP ITINERARIO CON TUTTI I PERCORSI ORDINATI
	 * public Map<Integer, Edge> itinerario(List<Edge> percorsiFatti) { Map<Integer,
	 * Edge> itinerario = new HashMap<Integer, Edge>();
	 * 
	 * Edge origine = percorsiFatti.get(0); // OTTENGO IL PERCORSO D'ORIGINE
	 * 
	 * Node nodoOrigine = origine.getOrigine(); // NODO D'ORIGINE
	 * 
	 * Node nodoDestinazioneOrigine = origine.getDestinazione(); // NODO D'ORIGINE
	 * 
	 * itinerario.put(0, origine); // INSERISCO IL PERCORSO N 1
	 * 
	 * // POI DEVO CERCARE NELLA LISTA PERCORSI IL PERCORSO CHE ABBIA COME ORIGINE
	 * LA // DESTINAZIONE DEL PERCORSO 1 for (Edge e : percorsiFatti) { if
	 * (e.getOrigine() == nodoDestinazioneOrigine) { itinerario.put(1, e); // SE LO
	 * TROVA LO AGGIUNGE ALL'HASHMAP } }
	 * 
	 * // POI DEL PERCORSO DUE DEVO PRENDERNE LA DESTINAZIONE E RIFARE IL CONTROLLO
	 * 
	 * Edge percorso2 = itinerario.get(1);
	 * 
	 * for (Edge e : percorsiFatti) { if (e.getOrigine() ==
	 * percorso2.getDestinazione()) { itinerario.put(2, e); // SE LO TROVA LO
	 * AGGIUNGE ALL'HASHMAP } }
	 * 
	 * Edge ultimoPercorso = new Edge(percorsiFatti.get(2).getDestinazione(),
	 * percorsiFatti.get(2).getOrigine(), percorsiFatti.get(2).getPeso());
	 * 
	 * itinerario.put(3, ultimoPercorso);
	 * 
	 * System.out.println(itinerario); return itinerario; }
	 * 
	 * 
	 */

}
