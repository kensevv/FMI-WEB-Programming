package fmi.web.backend.services;

import fmi.web.backend.entity.Contact;
import fmi.web.backend.entity.User;
import fmi.web.backend.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class ContactService {

    private final ContactRepository contactRepository;

    private boolean contactBelongsToCurrentUser(Contact contact) {
        return contact.getUser().equals(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact createContact(Contact contact) {
        contact.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return contactRepository.save(contact);
    }

    public Contact updateContact(Contact contact) {
        if (contactBelongsToCurrentUser(contact)) {
            return contactRepository.save(contact);
        } else {
            throw new RuntimeException();
        }
    }

    public void deleteContact(String id) {
        Optional<Contact> contact = contactRepository.findById(id);
        if (contact.isPresent() && contactBelongsToCurrentUser(contact.get())) {
            contactRepository.delete(contact.get());
        } else {
            throw new RuntimeException();
        }
    }
}
