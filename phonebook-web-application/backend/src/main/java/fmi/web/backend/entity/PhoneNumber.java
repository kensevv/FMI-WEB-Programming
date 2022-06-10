package fmi.web.backend.entity;

import javax.persistence.*;

@Entity
public class PhoneNumber {

    @Id
    private String phoneNumberUuid;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private PhoneType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_uu_id")
    private Contact contact;

    //setters and getters
    public String getPhoneNumberUuid() {
        return phoneNumberUuid;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public PhoneType getType() {
        return type;
    }

    public Contact getContact() {
        return contact;
    }

    public void setPhoneNumberUuid(String phoneNumberUuid) {
        this.phoneNumberUuid = phoneNumberUuid;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

}
