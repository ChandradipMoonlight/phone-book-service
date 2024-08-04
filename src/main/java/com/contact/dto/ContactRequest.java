package com.contact.dto;

import lombok.Data;

@Data
public class ContactRequest {
    private String primaryMobileNo;
    private String secondaryMobileNo;
    private String fullName;
    private String emailId;
}
