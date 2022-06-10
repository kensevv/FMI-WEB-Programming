package fmi.web.backend.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {
    @Id
    private String addressUuId;

    private String country;

    private String city;

    private String zipCode;

    private String street;

}
