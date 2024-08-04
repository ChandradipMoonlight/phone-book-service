package com.contact.dto;

import com.contact.enums.Status;
import lombok.Data;

@Data
public class ResponseRapper {
    private Status status;
    private Object data;
}
