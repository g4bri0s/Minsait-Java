package com.clients.entity;

import java.math.BigDecimal;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Setter;
import lombok.Getter;

@Entity
@Setter
@Getter
@Table(name = "client")
public class Client {

    @Id
    @NotNull(message = "CPF não pode estar vazio")
    private Long cpf;

    @NotBlank(message = "Nome não pode estar vazio")
    private String nome;

    @NotNull(message = "Telefone não pode estar vazio")
    private Long telefone;

    @Embedded
    private Address endereco;

    @NotNull(message = "Renda mensal não pode estar vazia")
    @DecimalMin(value = "0.01", message = "Renda mensal deve ser maior que 0 (zero)")
    private BigDecimal rendimentoMensal;

    @OneToMany(mappedBy = "cpfCliente", cascade = CascadeType.REMOVE)
    private List<Loan> loan;
}
