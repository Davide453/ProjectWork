package model;

public class User {

	private String nome;
	private String cognome;
	private String password;
	private String email;
	private int id;
	
	public User(String nome, String cognome, String passoword, String email) {
		
		this.nome = nome;
		this.cognome = cognome;
		this.password = password;
		this.email = email;
	}
	
	public User(String nome, String cognome, String passoword, String email,int id) {
		
		this.nome = nome;
		this.cognome = cognome;
		this.password = password;
		this.email = email;
		this.id = id;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
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
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [nome=" + nome + ", cognome=" + cognome + ", password=" + password + ", email=" + email + ", id="
				+ id + "]";
	}
	
	
	
	
	
}
