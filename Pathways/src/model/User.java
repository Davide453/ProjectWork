package model;

public class User {
	
	private String password;
	private String email;
	private int idUtenti;
	private String username;
	
	public User(String email,String password) {
		
		this.password = password;
		this.email = email;
	}
	
	public User(String password, String email,int id) {
		
		this.idUtenti = id;
		this.password = password;
		this.email = email;
	
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String Username) {
		this.username = username;
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
		return idUtenti;
	}

	public void setId(int id) {
		this.idUtenti = idUtenti;
	}

	@Override
	public String toString() {
		return "User [password=" + password + ", email=" + email + ", idUtenti=" + idUtenti + "]";
	}

	
	
	
	
	
	
}
