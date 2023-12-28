package com.example.ems.service.impl;

import com.example.ems.dto.ContactDto;
import com.example.ems.entity.Contact;
import com.example.ems.exception.ResourceNotFoundException;
import com.example.ems.mapper.ContactMapper;
import com.example.ems.repository.ContactsRepository;
import com.example.ems.service.ContactsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactsServiceImpl implements ContactsService {

    private ContactsRepository contactsRepository;

    public ContactsServiceImpl(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }

    public ContactsRepository getContactRepository() {
        return contactsRepository;
    }

    public void setContactRepository(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }

    @Override
    public ContactDto createContact(ContactDto contactDto) {

        Contact contact = ContactMapper.mapToContact(contactDto);
        Contact savedContact = contactsRepository.save(contact);
        return ContactMapper.mapToContactDto(savedContact);
    }

    @Override
    public ContactDto getContactById(Long contactId) {
        Contact contact = contactsRepository.findById(contactId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Contact does not exist with Id:" + contactId));
        return ContactMapper.mapToContactDto(contact);
    }

    @Override
    public List<ContactDto> getAllContacts() {
        List<Contact> contacts = contactsRepository.findAll();
        return contacts.stream().map((contact) -> ContactMapper.mapToContactDto(contact)).collect(Collectors.toList());
    }

    @Override
    public ContactDto updateContact(Long contactId, ContactDto updatedContact) {
        Contact contact = contactsRepository.findById(contactId).orElseThrow(
                () -> new ResourceNotFoundException("Contact does not exist with given id: " + contactId)
        );

        contact.setFirstName(updatedContact.getFirstName());
        contact.setLastName(updatedContact.getLastName());
        contact.setEmail(updatedContact.getEmail());

        Contact updatedContactObj = contactsRepository.save(contact);
        return ContactMapper.mapToContactDto(updatedContactObj);
    }

    @Override
    public void deleteContact(Long contactId) {

        Contact contact = contactsRepository.findById(contactId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Contact does not exist with Id:" + contactId));

        contactsRepository.deleteById(contactId);
    }

}
