package com.clients.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class IdChangeException extends Exception {

    private static final long serialVersionUID = 1L;

    public IdChangeException(Long cpf) {
        super(String.format("Client with cpf %s must continue with the same cpf", cpf));
    }
}
