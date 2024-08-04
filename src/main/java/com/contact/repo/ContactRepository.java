package com.contact.repo;

import com.contact.entity.ContactDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<ContactDetails, Integer> {
}
