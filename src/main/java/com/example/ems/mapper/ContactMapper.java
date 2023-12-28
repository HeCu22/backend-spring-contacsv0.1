package com.example.ems.mapper;

import com.example.ems.dto.ContactDto;
import com.example.ems.entity.Contact;


public class ContactMapper {
    public static ContactDto mapToContactDto(Contact contact) {
        return new ContactDto(
                contact.getId(),
                contact.getFirstName(),
                contact.getLastName(),
                contact.getEmail()
        );

    }

    public static Contact mapToContact(ContactDto contactDto) {


        return new Contact(
                contactDto.getId(),
                contactDto.getFirstName(),
                contactDto.getLastName(),
                contactDto.getEmail()
        );
    }
}
