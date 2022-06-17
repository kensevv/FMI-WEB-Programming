package fmi.web.backend.controllers;

import fmi.web.backend.dtos.ContactDTO;
import fmi.web.backend.dtos.PhoneNumberDTO;
import fmi.web.backend.entity.Contact;
import fmi.web.backend.entity.PhoneNumber;
import fmi.web.backend.entity.PhoneType;
import fmi.web.backend.exceptions.ContactNotFoundException;
import fmi.web.backend.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

	private final ContactService contactService;

	@Autowired
	public ContactController(ContactService contactService) {
		this.contactService = contactService;
	}

	@GetMapping("{id}")
	public ContactDTO getContact(@PathVariable String id) {
		Contact contact;
		try {
			contact = contactService.getContact(id);
		} catch (ContactNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact not found", e);
		}
		return mapContactEntityToDto(contact);
	}


	@GetMapping
	public List<ContactDTO> getAllContacts() {
		return contactService.getAllContacts().stream().map(this::mapContactEntityToDto).collect(Collectors.toList());
	}

	@PostMapping
	public Contact createContact(@RequestBody ContactDTO contact) {
		return contactService.updateOrInsertContact(mapContactDtoToEntity(contact));
	}

	@PutMapping
	public Contact updateContact(@RequestBody ContactDTO contact) {
		return contactService.updateOrInsertContact(mapContactDtoToEntity(contact));
	}

	@DeleteMapping("{id}")
	public void deleteContact(@PathVariable String id) {
		try {
			contactService.deleteContact(id);
		} catch (ContactNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact not found", e);
		}
	}

	private Contact mapContactDtoToEntity(ContactDTO dto) {
		return new Contact(
				dto.getContactUuid(),
				dto.getAddress(),
				dto.getEmail(), dto.getName(),
				dto.getPhoto().getBytes(),
				dto.getPhoneNumbers().stream().map(number -> new PhoneNumber(number.getPhoneNumberUuid(), number.getPhoneNumber(), PhoneType.valueOf(number.getType().toUpperCase()), new Contact(dto.getContactUuid()))).collect(Collectors.toList())
		);
	}

	private ContactDTO mapContactEntityToDto(Contact contact) {
		return new ContactDTO(
				contact.getContactUuid(),
				contact.getAddress(),
				contact.getEmail(),
				contact.getName(),
				new String(contact.getPhoto()),
				contact.getPhoneNumbers().stream().map(number -> new PhoneNumberDTO(number.getPhoneNumberUuid(), number.getPhoneNumber(), number.getType().name())).collect(Collectors.toList())
		);
	}
}
