package fmi.web.backend.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class PhoneNumber {

    @Id
    private String addressUuId;

    private String phoneNumber;

    @Enumerated(EnumType.ORDINAL)
    private PhoneType type;

}
