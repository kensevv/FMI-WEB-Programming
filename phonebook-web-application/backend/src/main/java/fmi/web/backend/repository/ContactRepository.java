package fmi.web.backend.repository;

import fmi.web.backend.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String>{

	List<Contact> findContactsByUser_UserUuid(String userUuid);
}
