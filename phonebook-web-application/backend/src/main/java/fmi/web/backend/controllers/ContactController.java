package fmi.web.backend.controllers;

import fmi.web.backend.entity.Contact;
import fmi.web.backend.entity.User;
import fmi.web.backend.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

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
        User currentUser = getCurrentUser();
        return currentUser.getContactList()
                .stream()
                .filter(c -> c.getContactUuid().equals(id))
                .findFirst()
                .orElse(null);
    }

    @GetMapping
    public List<Contact> getAllContacts() {
        return getCurrentUser().getContactList();
    }


    @PostMapping
    public Contact createContact(@RequestBody @Valid Contact contact) {
        return contactService.createContact(contact);
    }

    @PutMapping
    public Contact updateContact(@RequestBody @Valid Contact contact) {
        return contactService.updateContact(contact);
    }

    @DeleteMapping("{id}")
    public void deleteContact(@PathVariable String id) {
        contactService.deleteContact(id);
    }

    private User getCurrentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }


}
