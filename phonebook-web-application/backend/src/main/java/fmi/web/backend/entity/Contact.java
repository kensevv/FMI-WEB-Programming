package fmi.web.backend.entity;

import javax.persistence.*;
import java.sql.Blob;
import java.util.List;

@Entity
public class Contact {

    @Id
    private String contactUuId;

    private Address address;

    private String email;

    private String name;

    private Blob photo;

    @OneToMany(mappedBy = "contact")
    private List<PhoneNumber> phoneNumbers;

}
