package fmi.web.backend.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	private String addressUuid;

	private String country;

	private String city;

	private String zipCode;

	private String street;


	public Address() {

	}

	public Address(String addressUuid, String country, String city, String zipCode, String street) {
		this.addressUuid = addressUuid;
		this.country = country;
		this.city = city;
		this.zipCode = zipCode;
		this.street = street;
	}

	//setters and getters
	public String getAddressUuid() {
		return addressUuid;
	}

	public void setAddressUuid(String addressUuid) {
		this.addressUuid = addressUuid;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

}
