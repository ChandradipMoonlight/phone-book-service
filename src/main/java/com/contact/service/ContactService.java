package com.contact.service;

import com.contact.dto.ContactRequest;
import com.contact.dto.ContactResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ContactService {

    Integer addContactDetails(ContactRequest request);

    Integer updateContactDetails(ContactRequest request, int id);

    Integer deleteContact(int id);

    ContactResponse getDetails(int id);

    List<ContactResponse> fetchAllContacts();
}
