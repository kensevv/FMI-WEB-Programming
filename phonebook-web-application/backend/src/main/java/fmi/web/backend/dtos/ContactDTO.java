package fmi.web.backend.dtos;

import fmi.web.backend.entity.Address;

import java.util.List;

public class ContactDTO {
	private String contactUuid;
	private Address address;
	private String email;
	private String name;
	private String photo;
	private List<PhoneNumberDTO> phoneNumbers;

	public ContactDTO() {}

	public ContactDTO(String contactUuid, Address address, String email, String name, String photo, List<PhoneNumberDTO> phoneNumbers) {
		this.contactUuid = contactUuid;
		this.address = address;
		this.email = email;
		this.name = name;
		this.photo = photo;
		this.phoneNumbers = phoneNumbers;
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public List<PhoneNumberDTO> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<PhoneNumberDTO> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
}
