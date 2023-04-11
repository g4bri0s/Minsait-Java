package com.clients.dtos;

import java.math.BigDecimal;
import com.clients.entity.Address;
import com.clients.entity.Client;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClientDTOResponse {

    private Long cpf;
    private String nome;
    private Long telefone;
    @Embedded
    private Address endereco;
    private BigDecimal rendimentoMensal;

    public ClientDTOResponse(Client client) {
        this.cpf = client.getCpf();
        this.nome = client.getNome();
        this.telefone = client.getTelefone();
        this.endereco = client.getEndereco();
        this.rendimentoMensal = client.getRendimentoMensal();
    };
}