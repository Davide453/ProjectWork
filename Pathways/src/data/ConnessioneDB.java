package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import com.mysql.cj.jdbc.MysqlDataSource;

public class ConnessioneDB {
	
	private static Connection con = null;
	
	public static Connection getCon() {
		return con;
	}
	
	public static void connect() throws SQLException {
		
		if (con == null) {

			//oggeto di tipo MysqlDataSource per settare i parametri di configurazione
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setDatabaseName("Projectwork");
			dataSource.setPortNumber(3306);
			dataSource.setServerName("localhost");
			dataSource.setUser("root");
			dataSource.setPassword("");

			con = dataSource.getConnection();
			
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