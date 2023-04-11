package com.clients.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LoanNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public LoanNotFoundException(Long id) {
        super(String.format("Loan with id %s not found", id));
    }
}
