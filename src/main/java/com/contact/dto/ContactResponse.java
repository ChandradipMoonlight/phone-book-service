package com.contact.dto;

import lombok.Data;

@Data
public class ContactResponse {
    private int id;
    private String primaryMobNo;
    private String secMoNo;
    private String custName;
    private String emailId;
}
