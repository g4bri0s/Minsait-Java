package com.clients.dtos;

import java.math.BigDecimal;
import com.clients.entity.Address;
import com.clients.entity.Client;
import jakarta.persistence.Embedded;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClientDTORequest {

    private String cpf;
    private String nome;
    private String telefone;
    @Embedded
    private Address endereco;
    private BigDecimal rendimentoMensal;

    public ClientDTORequest(String cpf, String nome, String telefone, Address endereco, BigDecimal rendimentoMensal) {

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

    public Client returnUpdatedClient(ClientDTORequest clientDTORequest, Client client) {
        if (clientDTORequest.getNome() != null) {
            client.setNome(clientDTORequest.getNome());
        }

        if (clientDTORequest.getTelefone() != null) {
            client.setTelefone(clientDTORequest.getTelefone());
        }

        if (clientDTORequest.getEndereco() != null) {
            Address address = client.getEndereco();
            Address addressDTO = clientDTORequest.getEndereco();

            if (addressDTO.getCep() != null) {
                address.setCep(addressDTO.getCep());
            }

            if (addressDTO.getRua() != null) {
                address.setRua(addressDTO.getRua());
            }

            if (addressDTO.getNumero() != null) {
                address.setNumero(addressDTO.getNumero());
            }
        }

        if (clientDTORequest.getRendimentoMensal() != null) {
            client.setRendimentoMensal(clientDTORequest.getRendimentoMensal());
        }

        return client;
    }

}
