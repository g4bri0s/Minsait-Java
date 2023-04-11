package com.clients.dtos;

import java.math.BigDecimal;
import java.util.Date;

import com.clients.entity.Loan;
import com.clients.enums.RelationshipEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoanDTORequest {

    private Long id;
    private BigDecimal valorInicial;
    private RelationshipEnum relacionamento;
    private Date dataInicial;
    private Date dataFinal;
    private Long cpfCliente;

    public LoanDTORequest(Long id, BigDecimal valorInicial, RelationshipEnum relacionamento,
            Date dataInicial, Date dataFinal, Long cpfCliente) {
        this.id = id;
        this.valorInicial = valorInicial;
        this.relacionamento = relacionamento;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.cpfCliente = cpfCliente;
    }

    public Loan returnLoan(LoanDTORequest loanDTORequest) {
        Loan loan = new Loan();

        loan.setId(loanDTORequest.getId());
        loan.setValorInicial(loanDTORequest.getValorInicial());
        loan.setDataInicial(loanDTORequest.getDataInicial());
        loan.setDataFinal(loanDTORequest.getDataFinal());
        loan.setCpfCliente(loanDTORequest.getCpfCliente());
        loan.setRelacionamento(loanDTORequest.getRelacionamento());

        return loan;
    }
}
