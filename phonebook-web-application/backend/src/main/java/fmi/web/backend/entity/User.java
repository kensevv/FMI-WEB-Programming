package fmi.web.backend.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private String uuid;

    private String userName;

    private String password;

    private String email;

    private String firstName;

    private String lastName;


}
