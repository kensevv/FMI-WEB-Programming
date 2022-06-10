package fmi.web.backend.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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

    @ManyToOne
    private List<PhoneNumber> phoneNumbers;

}
