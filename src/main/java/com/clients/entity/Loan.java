package com.clients.entity;

import java.math.BigDecimal;
import java.util.Date;
import com.clients.enums.RelationshipEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "Loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private BigDecimal valorInicial;

    private BigDecimal valorFinal;

    @NotNull
    private RelationshipEnum relacionamento;

    @NotNull
    private Date dataInicial;

    @NotNull
    private Date dataFinal;

    private Long cpfCliente;

    public void setValorFinal(int clientLoanQuantity) {
        if (this.getValorInicial() != null) {
            this.valorFinal = this.relacionamento.calcFinalValue(this.getValorInicial(), clientLoanQuantity);
        }
    }
}