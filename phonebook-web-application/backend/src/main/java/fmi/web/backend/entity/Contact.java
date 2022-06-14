package fmi.web.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Contact {

	@Id
	private String contactUuid;

	@ManyToOne
	private Address address;

	private String email;

	private String name;

	private byte[] photo;

	@OneToMany(mappedBy = "contact", fetch = FetchType.EAGER)
	private List<PhoneNumber> phoneNumbers;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_uuid")
	private User user;

	public Contact() {

	}

	public Contact(String contactUuid) {
		this.contactUuid = contactUuid;
	}

	public Contact(String contactUuid, Address address, String email, String name, byte[] photo, List<PhoneNumber> phoneNumbers) {
		this.contactUuid = contactUuid;
		this.address = address;
		this.email = email;
		this.name = name;
		this.photo = photo;
		this.phoneNumbers = phoneNumbers;
	}

	public Contact(String contactUuid, Address address, String email, String name, byte[] photo, List<PhoneNumber> phoneNumbers, User user) {
		this.contactUuid = contactUuid;
		this.address = address;
		this.email = email;
		this.name = name;
		this.photo = photo;
		this.phoneNumbers = phoneNumbers;
		this.user = user;
	}

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

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
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
