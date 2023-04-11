package com.clients.dtos;

import java.math.BigDecimal;
import com.clients.entity.Address;
import com.clients.entity.Client;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClientDTORequest {

    @NotNull
    private Long cpf;
    private String nome;
    private Long telefone;
    @Embedded
    private Address endereco;
    private BigDecimal rendimentoMensal;

    public ClientDTORequest(Long cpf, String nome, Long telefone, Address endereco, BigDecimal rendimentoMensal) {

        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.rendimentoMensal = rendimentoMensal;
    };

    public Client returnClient(ClientDTORequest clientDTORequest) {
        Client client = new Client();

        client.setCpf(clientDTORequest.getCpf());
        client.setNome(clientDTORequest.getNome());
        client.setTelefone(clientDTORequest.getTelefone());
        client.setEndereco(clientDTORequest.getEndereco());
        client.setRendimentoMensal(clientDTORequest.getRendimentoMensal());
        return client;
    }

    public Client returnUpdaClient(ClientDTORequest clientDTORequest, Client client) {

        client.setCpf(clientDTORequest.getCpf());

        if (clientDTORequest.getNome() == null) {
            client.setNome(client.getNome());
        } else {
            client.setNome(clientDTORequest.getNome());
        }

        if (clientDTORequest.getTelefone() == null) {
            client.setTelefone(client.getTelefone());
        } else {
            client.setTelefone(clientDTORequest.getTelefone());
        }

        if (clientDTORequest.getEndereco() == null) {
            client.setEndereco(client.getEndereco());
        } else {
            client.setEndereco(clientDTORequest.getEndereco());
        }
        if (clientDTORequest.getRendimentoMensal() == null) {
            client.setRendimentoMensal(client.getRendimentoMensal());
        } else {
            client.setRendimentoMensal(clientDTORequest.getRendimentoMensal());
        }

        return client;
    }
}
