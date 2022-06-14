package fmi.web.backend.controllers;

import fmi.web.backend.entity.Contact;
import fmi.web.backend.exceptions.ContactNotFoundException;
import fmi.web.backend.exceptions.ContactNotPermitted;
import fmi.web.backend.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("{id}")
    public Contact getContact(@PathVariable String id) {
        Contact contact = null;
        try {
            contact = contactService.getContact(id);
        } catch (ContactNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact not found", e);
        }
        return contact;
    }

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @PostMapping
    public Contact createContact(@RequestBody @Valid Contact contact) {
        return contactService.createContact(contact);
    }

    @PutMapping
    public Contact updateContact(@RequestBody @Valid Contact contact) {
        Contact contactToUpdate = null;
        try {
            contactToUpdate = contactService.updateContact(contact);
        } catch (ContactNotPermitted e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Contact not accessible by current user", e);
        }
        return contactToUpdate;
    }

    @DeleteMapping("{id}")
    public void deleteContact(@PathVariable String id) {
        try {
            contactService.deleteContact(id);
        } catch (ContactNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact not found", e);
        }
    }
}
