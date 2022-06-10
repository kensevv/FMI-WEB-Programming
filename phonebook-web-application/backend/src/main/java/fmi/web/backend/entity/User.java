package fmi.web.backend.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class User {
    @Id
    private String userUuId;

    private String userName;

    private String password;

    private String email;

    private String firstName;

    private String lastName;

    @OneToMany
    @JoinColumn(name = "contacts")
    private List<Contact> contactList;
}
