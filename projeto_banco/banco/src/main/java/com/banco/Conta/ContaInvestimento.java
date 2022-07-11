package com.banco.Conta;

import java.math.BigDecimal;

public class ContaInvestimento extends Conta {
    private BigDecimal rendimentos;

    public ContaInvestimento(BigDecimal rendimentos){
        super();
        this.rendimentos = rendimentos;
    }

    public void investir(BigDecimal valor){
        // depositar(valor + valor*rendimentos);
        depositar(valor.add(valor.multiply(rendimentos)));
    }
    public BigDecimal getRendimentos() {
        return rendimentos;
    }
    public void setRendimentos(BigDecimal rendimentos) {
        this.rendimentos = rendimentos;
    }
}
