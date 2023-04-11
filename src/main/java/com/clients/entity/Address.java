package com.clients.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Setter
@Getter
public class Address {
    private String rua;
    private String cep;
    private Long numero;

}
