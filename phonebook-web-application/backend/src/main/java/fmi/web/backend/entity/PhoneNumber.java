package fmi.web.backend.entity;

import javax.persistence.*;

@Entity
public class PhoneNumber {

    @Id
    private String phoneNumberUuId;

    private String phoneNumber;

    @Enumerated(EnumType.ORDINAL)
    private PhoneType type;

    @ManyToOne
    @JoinColumn(name = "contactUuId")
    private Contact contact;

}
