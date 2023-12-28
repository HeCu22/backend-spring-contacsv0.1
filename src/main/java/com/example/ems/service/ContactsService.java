package com.example.ems.service;

import com.example.ems.dto.ContactDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ContactsService {
    ContactDto createContact(ContactDto contactDto);

    ContactDto getContactById(Long contactId);

    List<ContactDto> getAllContacts();

    ContactDto updateContact(Long contactId, ContactDto updatedContact);

    void deleteContact(Long contactId);
}
