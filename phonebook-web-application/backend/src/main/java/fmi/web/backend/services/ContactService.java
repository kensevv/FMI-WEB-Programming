package fmi.web.backend.services;

import fmi.web.backend.entity.Contact;
import fmi.web.backend.entity.PhoneNumber;
import fmi.web.backend.entity.User;
import fmi.web.backend.exceptions.ContactNotFoundException;
import fmi.web.backend.repository.AddressRepository;
import fmi.web.backend.repository.ContactRepository;
import fmi.web.backend.repository.PhoneNumberRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ContactService {

	private final ContactRepository contactRepository;
	private final AddressRepository addressRepository;
	private final PhoneNumberRepository phoneNumberRepository;

	@Autowired
	public ContactService(ContactRepository contactRepository, AddressRepository addressRepository, PhoneNumberRepository phoneNumberRepository) {
		this.contactRepository = contactRepository;
		this.addressRepository = addressRepository;
		this.phoneNumberRepository = phoneNumberRepository;
	}

	private User getCurrentUser() {
		return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	private boolean contactBelongsToCurrentUser(Contact contact) {
		return contact.getUser().getUserUuid().equals(getCurrentUser().getUserUuid());
	}

	public Contact updateOrInsertContact(Contact contact) {
		List<PhoneNumber> phoneNumbers = contact.getPhoneNumbers();
		contact.setPhoneNumbers(null);
		contact.setUser(getCurrentUser());
		addressRepository.save(contact.getAddress());
		Contact newContact = contactRepository.save(contact);
		phoneNumberRepository.saveAll(phoneNumbers);
		return newContact;
	}

	public Contact getContact(String id) throws ContactNotFoundException {
		return contactRepository.findById(id).orElseThrow(ContactNotFoundException::new);
	}

	public List<Contact> getAllContacts() {
		return contactRepository.findContactsByUser_UserUuid(getCurrentUser().getUserUuid());
	}

	public void deleteContact(String id) throws ContactNotFoundException {
		Optional<Contact> contact = contactRepository.findById(id);
		if (contact.isPresent() && contactBelongsToCurrentUser(contact.get())) {
			Contact contactValue = contact.get();
			phoneNumberRepository.deleteAll(contactValue.getPhoneNumbers());
			contactRepository.delete(contact.get());
			addressRepository.delete(contactValue.getAddress());
		} else {
			throw new ContactNotFoundException();
		}
	}
}
