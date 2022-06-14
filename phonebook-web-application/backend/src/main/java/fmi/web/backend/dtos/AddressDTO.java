package fmi.web.backend.dtos;

public class AddressDTO {
	private String addressUuid;

	private String country;

	private String city;

	private String zipCode;

	private String street;

	public AddressDTO() {
	}

	public AddressDTO(String addressUuid, String country, String city, String zipCode, String street) {
		this.addressUuid = addressUuid;
		this.country = country;
		this.city = city;
		this.zipCode = zipCode;
		this.street = street;
	}

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
