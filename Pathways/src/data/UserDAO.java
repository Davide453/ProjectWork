package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;

public class UserDAO {

	public static void insertUtente(User utente) {

		try {
			ConnessioneDB.connect();
			String query = "INSERT INTO Utenti (email,password,nPercorsi) VALUES" + "(?,?,?);";

			PreparedStatement st = ConnessioneDB.getCon().prepareStatement(query);

			st.setString(1, utente.getEmail());
			st.setString(2, utente.getPassword());
			st.setInt(3, 0);

			st.executeUpdate();
			System.out.println("Query di inserimento eseguita correttamente" + utente);

			ConnessioneDB.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static User selectUserFromId(int idUtenti) {
		User user = null;
		System.out.println("select user ");
		try {
			ConnessioneDB.connect();
			String query = "SELECT * from Utenti WHERE idUtenti=?";
			PreparedStatement st = ConnessioneDB.getCon().prepareStatement(query);
			st.setInt(1, idUtenti);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String email = rs.getString("email");
				String password = rs.getString("password");
				int rsIdUtenti = rs.getInt("idUtenti");
				int nPercorsi = rs.getInt("nPercorsi");
				user = new User(email, password, rsIdUtenti, nPercorsi);
			}
			ConnessioneDB.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Query di selezione(id) eseguita correttamente" + user);
		return user;
	}

	public static User selectUserFromPassEmail(String email, String password) {
		User user = null;
		try {
			ConnessioneDB.connect();
			String query = "SELECT * from Utenti WHERE email=? and password=?;";
			PreparedStatement st = ConnessioneDB.getCon().prepareStatement(query);
			st.setString(1, email);
			st.setString(2, password);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String resultEmail = rs.getString("email");
				String resultPassword = rs.getString("password");

				int idUtenti = rs.getInt("IdUtenti");
				int nPercorsi = rs.getInt("nPercorsi");
				user = new User(resultEmail, resultPassword, idUtenti, nPercorsi);
			}

			ConnessioneDB.close();

		} catch (SQLException e) {
			System.out.println("Errore");
			e.printStackTrace();
		}

		return user;
	}

}
