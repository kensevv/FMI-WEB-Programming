package fmi.web.backend.entity;

import javax.persistence.*;
import java.sql.Blob;
import java.util.List;

@Entity
public class Contact {

	@Id
	private String contactUuid;

	@ManyToOne
	private Address address;

	private String email;

	private String name;

	@Lob
	private Blob photo;

	@OneToMany(mappedBy = "contact", fetch = FetchType.LAZY)
	private List<PhoneNumber> phoneNumbers;

	@ManyToOne
	@JoinColumn(name = "user_uuid")
	private User user;

	public Contact() {

	}

	public Contact(String contactUuid, Address address, String email, String name, Blob photo, List<PhoneNumber> phoneNumbers, User user) {
		this.contactUuid = contactUuid;
		this.address = address;
		this.email = email;
		this.name = name;
		this.photo = photo;
		this.phoneNumbers = phoneNumbers;
		this.user = user;
	}

	// setters and getters
	public String getContactUuid() {
		return contactUuid;
	}

	public void setContactUuid(String contactUuid) {
		this.contactUuid = contactUuid;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}

	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
