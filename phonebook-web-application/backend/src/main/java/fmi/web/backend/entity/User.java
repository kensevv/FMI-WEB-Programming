package fmi.web.backend.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PhoneBookUser")
public class User {

    @Id
    private String userUuid;

    private String username;

    private String password;

    private String email;

    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = "user")
    private List<Contact> contactList;

    //setters and getters
    public String getUserUuid() {
        return userUuid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

}
