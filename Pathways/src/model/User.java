package model;

public class User {

	private String password;
	private String email;
	private int idUtente;

	private int nPercorsi;

	public User(String email, String password) {
		this.password = password;
		this.email = email;
		nPercorsi = 0;
	}

	public User(String password, String email, int idUtente, int nPercorsi) {
		this.idUtente = idUtente;
		this.password = password;
		this.email = email;
		this.nPercorsi = nPercorsi;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return idUtente;
	}

	public int getnPercorsi() {
		return nPercorsi;
	}

	public void setnPercorsi(int nPercorsi) {
		this.nPercorsi = nPercorsi;
	}

	@Override
	public String toString() {
		return "User [password=" + password + ", email=" + email + ", idUtente=" + idUtente + ", nPercorsi=" + nPercorsi
				+ "]";
	}

}
