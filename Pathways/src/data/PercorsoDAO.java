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

	public static ArrayList<Percorso> selectPercorsoFromIdUtente(int idUtente) {
		Percorso percorso = new Percorso();
		ArrayList<Percorso> arrayPercorso = new ArrayList<>();
AttrazioneNodo nodo = new AttrazioneNodo();
		try {
			ConnessioneDB.connect();
			PreparedStatement st = ConnessioneDB.getCon().prepareStatement(SELECT_PERCORSO_BY_ID_UTENTE);
			st.setInt(1, idUtente);
			System.out.println(idUtente);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int rsIdUtente = rs.getInt("idUtente");
				String nome = rs.getString("nome");
				String indirizzo = rs.getString("indirizzo");
				int ordine = rs.getInt("ordine");
				int idPercorso = rs.getInt("idPercorso");

				
			}

			System.out.println(arrayPercorso);
			ConnessioneDB.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayPercorso;
	}

}
