package com.example.ems.controller;

import com.example.ems.dto.ContactDto;
import com.example.ems.service.ContactsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private ContactsService contactsService;

    public ContactController(ContactsService contactsService) {
        this.contactsService = contactsService;
    }

    // Buid Add  Contact REST API
    @PostMapping
    public ResponseEntity<ContactDto> createContact(@RequestBody ContactDto contactDto) {
        ContactDto savedContact = contactsService.createContact(contactDto);
        return new ResponseEntity<>(savedContact, HttpStatus.CREATED);
    }

    // Buid Get Contact REST API
    @GetMapping("{id}")
    public ResponseEntity<ContactDto> getContactById(@PathVariable("id") Long ContactId) {
        ContactDto contactDto = contactsService.getContactById(ContactId);
        return ResponseEntity.ok(contactDto);
    }

    //Build get All Contacts REST API
    @GetMapping
    public ResponseEntity<List<ContactDto>> getAllContacts() {
        List<ContactDto> Contacts = contactsService.getAllContacts();
        return ResponseEntity.ok(Contacts);
    }

    //Build update Contact REST API
    @PutMapping("{id}")
    public ResponseEntity<ContactDto> updateContact(@PathVariable("id") Long ContactId,
                                                     @RequestBody ContactDto updateContact) {
        ContactDto contactDto = contactsService.updateContact(ContactId, updateContact);
        return ResponseEntity.ok(contactDto);
    }

    //Build delete Contact REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteContact(@PathVariable("id") Long ContactId) {
        contactsService.deleteContact(ContactId);
        return ResponseEntity.ok("Contact deleted successfully.");
    }
}
