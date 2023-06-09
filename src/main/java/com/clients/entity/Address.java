package com.clients.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Setter
@Getter
public class Address {

    @NotBlank(message = "Rua não pode estar vazio")
    private String rua;

    @NotBlank(message = "CEP não pode estar vazio")
    private String cep;

    @NotNull(message = "Número não pode estar vazio")
    private Long numero;

}
