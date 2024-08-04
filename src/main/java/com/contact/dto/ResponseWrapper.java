package com.contact.dto;

import com.contact.enums.Status;
import lombok.Data;

@Data
public class ResponseWrapper {
    private Status status;
    private Object data;
    public ResponseWrapper(Status status, Object data) {
        this.status = status;
        this.data = data;
    }
}
