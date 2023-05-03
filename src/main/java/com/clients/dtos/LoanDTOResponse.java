package com.clients.dtos;

import java.math.BigDecimal;
import java.util.Date;

import com.clients.entity.Loan;
import com.clients.enums.RelationshipEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoanDTOResponse {

    private BigDecimal valorInicial;
    private BigDecimal valorFinal;
    private RelationshipEnum relacionamento;
    private Date dataInicial;
    private Date dataFinal;
    private String cpfCliente;

    public LoanDTOResponse(Loan loan) {
        this.valorInicial = loan.getValorInicial();
        this.valorFinal = loan.getValorFinal();
        this.relacionamento = loan.getRelacionamento();
        this.dataInicial = loan.getDataInicial();
        this.dataFinal = loan.getDataFinal();
        this.cpfCliente = loan.getCpfCliente();
    };
}