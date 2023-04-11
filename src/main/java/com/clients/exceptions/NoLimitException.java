package com.clients.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class NoLimitException extends Exception {

    private static final long serialVersionUID = 1L;

    public NoLimitException(Long cpf) {
        super(String.format("Client with cpf %s has no limit to contracting this loan", cpf));
    }
}