package com.clients.enums;

import java.math.BigDecimal;
import java.math.MathContext;

public enum RelationshipEnum {

    Bronze(1) {
        @Override
        public BigDecimal calcFinalValue(BigDecimal valorInicial, int clientLoanQuantity) {
            BigDecimal multiplier = new BigDecimal(1.8);
            return valorInicial.multiply(multiplier, MathContext.DECIMAL32);
        }
    },

    Prata(2) {
        @Override
        public BigDecimal calcFinalValue(BigDecimal valorInicial, int clientLoanQuantity) {
            if ((valorInicial.compareTo(new BigDecimal(5000))) == 1) {
                BigDecimal multiplier = new BigDecimal(1.4);
                return valorInicial.multiply(multiplier, MathContext.DECIMAL32);
            } else {
                BigDecimal multiplier = new BigDecimal(1.6);
                return valorInicial.multiply(multiplier, MathContext.DECIMAL32);
            }
        }
    },

    Ouro(3) {
        @Override
        public BigDecimal calcFinalValue(BigDecimal valorInicial, int clientLoanQuantity) {
            if (clientLoanQuantity == 0) {
                BigDecimal multiplier = new BigDecimal(1.2);
                return valorInicial.multiply(multiplier, MathContext.DECIMAL32);
            } else {
                BigDecimal multiplier = new BigDecimal(1.3);
                return valorInicial.multiply(multiplier, MathContext.DECIMAL32);
            }
        };
    };

    private int value;

    private RelationshipEnum(int value) {

        this.value = value;
    }

    public int getCodigo() {
        return this.value;
    }

    public abstract BigDecimal calcFinalValue(BigDecimal valorInicial, int clientLoanQuantity);
}