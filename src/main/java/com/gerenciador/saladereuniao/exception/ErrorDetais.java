package com.gerenciador.saladereuniao.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ErrorDetais {
    private Date timestamp;
    private String message;
    private String details;

    public ErrorDetais(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
}
