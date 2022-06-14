package fmi.web.backend.dtos;

import fmi.web.backend.entity.PhoneType;

public class PhoneNumberDTO {
	private String phoneNumberUuid;
	private String phoneNumber;
	private String type;

	public PhoneNumberDTO() {
	}

	public PhoneNumberDTO(String phoneNumberUuid, String phoneNumber, String type) {
		this.phoneNumberUuid = phoneNumberUuid;
		this.phoneNumber = phoneNumber;
		this.type = type;
	}

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
