package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.AttrazioneNodo;
import model.Percorso;
import model.User;

public class PercorsoDAO {

	private final static String NUOVO_PERCORSO = "INSERT INTO percorsi (idPercorso,idUtente,ordine,indirizzo,nome) VALUES"
			+ "(?,?,?,?,?);";
	private static final String SELECT_PERCORSO_BY_ID_PERCORSO = "select * from percorsi where (idPercorso=?)";
	private static final String SELECT_PERCORSO_BY_ID_UTENTE = "select * from percorsi where (idUtente=?)";

	private static final String SELECT_ALL_USER = "SELECT * from userdb.user";
	private static final String UPDATE_PERCORSO = "UPDATE user SET name=?, email=?, country=? WHERE id=?;";
	private static final String DELETE_PERCORSO = "delete from user where id=?";

	public static void insertPercorso(Percorso percorso, User user) {
		try {
			ConnessioneDB.connect();
			PreparedStatement st = ConnessioneDB.getCon().prepareStatement(NUOVO_PERCORSO);
			System.out.println(user);
			for (AttrazioneNodo nodo : percorso.getOrdineNodi()) {
				System.out.println(nodo);
				st.setInt(1, user.getnPercorsi());
				st.setInt(2, user.getId());
				st.setInt(3, nodo.getOrdine());
				st.setString(4, nodo.getViaAttrazione());
				st.setString(5, nodo.getNomeAttrazione());

				st.executeUpdate();
			}
			user.setnPercorsi(user.getnPercorsi() + 1);
			System.out.println(user.getnPercorsi());
			ConnessioneDB.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Percorso selectPercorsoFromIdPercorso(int idPercorso) {
		Percorso percorso = new Percorso();
		AttrazioneNodo nodo = null;
		ArrayList<AttrazioneNodo> nodi = new ArrayList<>();
		try {
			ConnessioneDB.connect();
			PreparedStatement st = ConnessioneDB.getCon().prepareStatement(SELECT_PERCORSO_BY_ID_PERCORSO);
			st.setInt(1, idPercorso);
			ResultSet rs = st.executeQuery();

			int rsIdPercorso = rs.getInt("idPercorso");
			int idUtente = rs.getInt("idUtente");
			System.out.println("idPercoso: " + rsIdPercorso);
			while (rs.next()) {
				String nodoNome = rs.getString("nome");
				String nodoIndirizzo = rs.getString("indirizzo");
				int nodoPosizione = rs.getInt("ordine");
				nodo = new AttrazioneNodo(nodoNome, nodoIndirizzo, nodoPosizione);
				nodi.add(nodo);
				System.out.println(nodo);
			}
			percorso.setOrdineNodi(nodi);
			percorso.setIdUtente(idUtente);
			percorso.setIdPercorso(rsIdPercorso);

			System.out.println("query percorso" + percorso);
			ConnessioneDB.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Query di selezione(idPercorso) eseguita correttamente" + percorso);
		return percorso;
	}

	public static ArrayList<Percorso> selectPercorsoFromIdUtente(int idUtente) {
		Percorso percorso = new Percorso();
		ArrayList<Percorso> arrayPercorso = new ArrayList<>();

		try {
			ConnessioneDB.connect();
			PreparedStatement st = ConnessioneDB.getCon().prepareStatement(SELECT_PERCORSO_BY_ID_UTENTE);
			st.setInt(1, idUtente);
			System.out.println(idUtente);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int rsIdPercorso = rs.getInt("idPercorso");

				percorso = PercorsoDAO.selectPercorsoFromIdPercorso(rsIdPercorso);
				System.out.println(percorso);
				arrayPercorso.add(percorso);
			}

			System.out.println(arrayPercorso);
			ConnessioneDB.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayPercorso;
	}

	public static Percorso selectPercorsoFromIdUtenteIdPercorso(int idUtente) {
		Percorso percorso = new Percorso();
		ArrayList<Percorso> arrayPercorso = new ArrayList<>();

		try {
			ConnessioneDB.connect();
			PreparedStatement st = ConnessioneDB.getCon().prepareStatement(SELECT_PERCORSO_BY_ID_UTENTE);
			st.setInt(1, idUtente);
			System.out.println(idUtente);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int rsIdPercorso = rs.getInt("idPercorso");

				percorso = PercorsoDAO.selectPercorsoFromIdPercorso(rsIdPercorso);
				System.out.println(percorso);
				arrayPercorso.add(percorso);
			}

			System.out.println(arrayPercorso);
			ConnessioneDB.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return percorso;
	}

}
