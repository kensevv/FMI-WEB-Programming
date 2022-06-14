package fmi.web.backend.repository;

import fmi.web.backend.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, String>{
}
