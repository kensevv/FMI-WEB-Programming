package fmi.web.backend.model;

import javax.persistence.*;

//@Entity
@NamedQuery(name = User.getUserByUsername, query = "SELECT u FROM User u WHERE u.username = :username")
public class User extends BaseEntity{
	public static final String getUserByUsername = "getUserByUsername";

	@Column(unique = true, nullable = false)
	private String email;
	@Column(unique = true, nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

