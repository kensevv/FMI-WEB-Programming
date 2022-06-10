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
}
