package fmi.web.backend.services;

import fmi.web.backend.entity.Contact;
import fmi.web.backend.entity.User;
import fmi.web.backend.exceptions.ContactNotFoundException;
import fmi.web.backend.exceptions.ContactNotPermitted;
import fmi.web.backend.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

	private final ContactRepository contactRepository;

	@Autowired
	public ContactService(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}

	private User getCurrentUser() {
		return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	private boolean contactBelongsToCurrentUser(Contact contact) {
		return contact.getUser().getUserUuid().equals(getCurrentUser().getUserUuid());
	}

	public Contact createContact(Contact contact) {
		contact.setUser(getCurrentUser());
		return contactRepository.save(contact);
	}

	public Contact getContact(String id) throws ContactNotFoundException {
		return contactRepository.findById(id).orElseThrow(ContactNotFoundException::new);
	}

	public List<Contact> getAllContacts() {
		return contactRepository.findContactsByUser_UserUuid(getCurrentUser().getUserUuid());
	}

	public Contact updateContact(Contact contact) throws ContactNotPermitted {
		if (contactBelongsToCurrentUser(contact)) {
			return contactRepository.save(contact);
		} else {
			throw new ContactNotPermitted();
		}
	}

	public void deleteContact(String id) throws ContactNotFoundException {
		Optional<Contact> contact = contactRepository.findById(id);
		if (contact.isPresent() && contactBelongsToCurrentUser(contact.get())) {
			contactRepository.delete(contact.get());
		} else {
			throw new ContactNotFoundException();
		}
	}
}
