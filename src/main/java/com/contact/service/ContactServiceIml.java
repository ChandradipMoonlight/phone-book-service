package com.contact.service;

import com.contact.dto.ContactRequest;
import com.contact.dto.ContactResponse;
import com.contact.entity.ContactDetails;
import com.contact.exception.ContactException;
import com.contact.repo.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceIml implements ContactService{

    @Autowired
    private ContactRepository contactRepository;


    private ContactDetails covertContactDetails(ContactRequest request) {
        ContactDetails details = new ContactDetails();
        if (request.getFullName()==null) {
            throw new ContactException("Please provide Name");
        }
        details.setFullName(request.getFullName());
        if (request.getPrimaryMobileNo()==null) {
            throw new ContactException("Mobile Provide Mobile number");
        }
        details.setPrimaryMobileNo(request.getPrimaryMobileNo());
        if (request.getSecondaryMobileNo()!=null) {
            details.setSecondaryMobileNo(request.getSecondaryMobileNo());
        }
        if (request.getEmailId()!=null){
            details.setEmailId(request.getEmailId());
        }
        return details;
    }

    @Override
    public Integer addContactDetails(ContactRequest request) {
        ContactDetails details = covertContactDetails(request);
        ContactDetails savedDetails = contactRepository.save(details);
        return savedDetails.getId();
    }

    @Override
    public Integer updateContactDetails(ContactRequest request, int id) {
        ContactDetails details = contactRepository.findById(id)
                .orElseThrow(() -> new ContactException("Contact Details not found"));
        if (request.getPrimaryMobileNo()!=null) {
            details.setPrimaryMobileNo(request.getPrimaryMobileNo());
        }
        if (request.getSecondaryMobileNo()!=null) {
            details.setSecondaryMobileNo(request.getSecondaryMobileNo());
        }
        if (request.getFullName()!=null) {
            details.setFullName(request.getFullName());
        }
        if (request.getEmailId()!=null) {
            details.setEmailId(request.getEmailId());
        }
        contactRepository.save(details);
        return details.getId();
    }

    @Override
    public Integer deleteContact(int id) {
        ContactDetails details = contactRepository.findById(id)
                .orElseThrow(() -> new ContactException("Contact Details not found"));
        contactRepository.delete(details);
        return details.getId();
    }

    @Override
    public ContactResponse getDetails(int id) {
        ContactDetails details = contactRepository.findById(id)
                .orElseThrow(() -> new ContactException("Contact Details not found"));
        return getContactResponse(details);
    }

    @Override
    public List<ContactResponse> fetchAllContacts() {
        return contactRepository.findAll()
                .stream()
                .map(this::getContactResponse)
                .collect(Collectors.toList());
//        List<ContactResponse> responses = new ArrayList<>();
//        List<ContactDetails> contactDetails = contactRepository.findAll();
//        for (ContactDetails contactDetail : contactDetails) {
//            ContactResponse contactResponse = getContactResponse(contactDetail);
//            responses.add(contactResponse);
//        }
//        return responses;
    }

    private ContactResponse getContactResponse(ContactDetails contactDetails) {
        ContactResponse response =  new ContactResponse();
        response.setId(contactDetails.getId());
        response.setPrimaryMobileNo(contactDetails.getPrimaryMobileNo());
        response.setFullName(contactDetails.getFullName());
        if (contactDetails.getEmailId()!=null) {
            response.setEmailId(contactDetails.getEmailId());
        }
        if (contactDetails.getSecondaryMobileNo()!=null) {
            response.setSecondaryMobileNo(contactDetails.getSecondaryMobileNo());
        }
        return response;
    }
}
