package com.example.ems.repository;

import com.example.ems.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactsRepository extends JpaRepository<Contact, Long> {
}
