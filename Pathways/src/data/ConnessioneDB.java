package data;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ConnessioneDB {

	private static Connection con;
	// parametri di configurazione del DB
	private static final String NOME_DB = "mysocialnetwork";
	private static final int PORT = 3306;
	private static final String SERVER_NAME = "localhost";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "MySQL921PW";

	public ConnessioneDB() {
		ConnessioneDB.con = null;
	}

	public static Connection getCon() {
		return con;
	}

	public static void setCon(Connection con) {
		ConnessioneDB.con = con;
	}

	public static void connect() throws SQLException {
		if (con == null) {

			MysqlDataSource source = new MysqlDataSource();
			source.setDatabaseName(NOME_DB);
			source.setPortNumber(PORT);
			source.setServerName(SERVER_NAME);
			source.setUser(USERNAME);
			source.setPassword(PASSWORD);

			con = source.getConnection();

			System.out.println("Connessione avvenuta con il database : " + con.getCatalog());

		}
	}

	public static void close() throws SQLException {
		try {
			con.close();
			con = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
