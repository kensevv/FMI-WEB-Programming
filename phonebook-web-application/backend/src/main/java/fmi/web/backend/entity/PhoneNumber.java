package fmi.web.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class PhoneNumber {

	@Id
	private String phoneNumberUuid;

	private String phoneNumber;

	@Enumerated(EnumType.STRING)
	private PhoneType type;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "contact_uuid")
	private Contact contact;


	public PhoneNumber() {

	}

	public PhoneNumber(String phoneNumberUuid, String phoneNumber, PhoneType type, Contact contact) {
		this.phoneNumberUuid = phoneNumberUuid;
		this.phoneNumber = phoneNumber;
		this.type = type;
		this.contact = contact;
	}

	//setters and getters
	public String getPhoneNumberUuid() {
		return phoneNumberUuid;
	}

	public void setPhoneNumberUuid(String phoneNumberUuid) {
		this.phoneNumberUuid = phoneNumberUuid;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public PhoneType getType() {
		return type;
	}

	public void setType(PhoneType type) {
		this.type = type;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

}
