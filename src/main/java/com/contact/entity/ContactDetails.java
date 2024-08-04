package com.contact.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class ContactDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
   private String primaryMobNo;
   private String secMoNo;
   private String custName;
   private String emailId;
}
