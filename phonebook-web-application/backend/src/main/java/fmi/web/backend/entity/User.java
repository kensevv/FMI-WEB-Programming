package fmi.web.backend.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "phonebook_user")
@NamedQuery(name = User.getUserByUsername, query = "SELECT u FROM User u WHERE u.username = :username")
@NamedQuery(name = User.getUserByEmail, query = "SELECT u FROM User u WHERE u.email = :email")
public class User {
	public static final String getUserByUsername = "getUserByUsername";
	public static final String getUserByEmail = "getUserByEmail";

	@Id
	private String userUuid;

	private String username;

	private String password;

	private String email;

	private String firstName;

	private String lastName;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Contact> contactList;

	public User() {

	}

	public User(String userUuid, String username, String password, String email, String firstName, String lastName, List<Contact> contactList) {
		this.userUuid = userUuid;
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactList = contactList;
	}

	//setters and getters
	public String getUserUuid() {
		return userUuid;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}

}
