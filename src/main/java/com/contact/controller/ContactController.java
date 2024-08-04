package com.contact.controller;

import com.contact.dto.ContactRequest;
import com.contact.dto.ResponseWrapper;
import com.contact.enums.Status;
import com.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact/v1")
public class ContactController {

    @Autowired
    ContactService contactService;

    @PostMapping("/add")
    public ResponseEntity<ResponseWrapper> addContact(@RequestBody ContactRequest request) {
        Integer id = contactService.addContactDetails(request);
        return new ResponseEntity<>(new ResponseWrapper(Status.SUCCESS, id), HttpStatus.OK);
    }

    @PostMapping("/{id}/update")
    public ResponseEntity<ResponseWrapper> updateContact(@RequestBody ContactRequest request, @PathVariable(value = "id") Integer id) {
        Integer updatedId = contactService.updateContactDetails(request, id);
        return ResponseEntity.ok(new ResponseWrapper(Status.SUCCESS, updatedId));
    }

    @GetMapping(value = "/get")
    public ResponseEntity<ResponseWrapper> getContactDetails(@RequestParam(value = "id") Integer id) {
        return ResponseEntity.ok(
                new ResponseWrapper(Status.SUCCESS, contactService.getDetails(id))
        );
    }
    @GetMapping(value = "/all")
    public ResponseEntity<ResponseWrapper> fetchAllContacts() {
        return ResponseEntity.ok(
          new ResponseWrapper(Status.SUCCESS, contactService.fetchAllContacts())
        );
    }
}
