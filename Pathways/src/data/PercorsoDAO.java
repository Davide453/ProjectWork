package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.AttrazioneNodo;
import model.Percorso;
import model.User;

public class PercorsoDAO {

	private final static String NUOVO_PERCORSO = "INSERT INTO pathways.percorsi (idPercorso,idUtente,nomePercorso,ordine,indirizzo,nome) VALUES"
			+ "(?,?,?,?,?,?);";
	private static final String SELECT_PERCORSO_BY_ID_UTENTE_ID_PERCORSO = "select * from percorsi where (idPercorso =? and idUtente=?);";

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
				st.setString(3, "Itinerario " + user.getnPercorsi());
				st.setInt(4, nodo.getOrdine());
				st.setString(5, nodo.getViaAttrazione());
				st.setString(6, nodo.getNomeAttrazione());

				st.executeUpdate();
			}

			System.out.println(user.getnPercorsi());
			ConnessioneDB.close();
			UserDAO.updateUserNPercorsi(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Percorso> selectPercorsoFromIdUtente(User user) {

		ArrayList<Percorso> arrayPercorso = new ArrayList<>();

		System.out.println("inizio percorsoDAO ");
		System.out.println(user);
		PreparedStatement st;
		try {
			ConnessioneDB.connect();
			for (int i = 0; i < user.getnPercorsi(); i++) {
				Percorso percorso = new Percorso();
				AttrazioneNodo nodo = null;
				ArrayList<AttrazioneNodo> ordineNodi = new ArrayList<>();
				System.out.println("loop n: " + i);
				st = ConnessioneDB.getCon().prepareStatement(SELECT_PERCORSO_BY_ID_UTENTE_ID_PERCORSO);
				st.setInt(1, i);
				st.setInt(2, user.getId());

				ResultSet rs = st.executeQuery();
				int rsIdUtente = 0;
				int idPercorso = 0;
				String nomePercorso = "";
				while (rs.next()) {
					rsIdUtente = rs.getInt("idUtente");
					idPercorso = rs.getInt("idPercorso");
					int ordine = rs.getInt("ordine");
					String nome = rs.getString("nome");
					nomePercorso = rs.getString("nomePercorso");
					String indirizzo = rs.getString("indirizzo");
					nodo = new AttrazioneNodo(nome, indirizzo, ordine);
					ordineNodi.add(nodo);
				}
				
				percorso.setNome(nomePercorso);
				percorso.setIdPercorso(idPercorso);
				percorso.setIdUtente(rsIdUtente);
				percorso.setOrdineNodi(ordineNodi);
				arrayPercorso.add(percorso);
				System.out.println("test Percorso" + percorso);

			}
			System.out.println("test arrayPercorso" + arrayPercorso);
			ConnessioneDB.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayPercorso;
	}
}
