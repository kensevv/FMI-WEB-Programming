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

    @javax.persistence.Lob
    private Blob photo;

    @OneToMany(mappedBy = "contact", fetch = FetchType.LAZY)
    private List<PhoneNumber> phoneNumbers;

    @ManyToOne
    @JoinColumn(name = "user_uu_id")
    private User user;

    // setters and getters
    public String getContactUuid() {
        return contactUuid;
    }

    public Address getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Blob getPhoto() {
        return photo;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public User getUser() {
        return user;
    }

    public void setContactUuid(String contactUuid) {
        this.contactUuid = contactUuid;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
