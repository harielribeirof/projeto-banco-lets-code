package com.banco.Pessoa;

import java.math.BigDecimal;

import com.banco.Conta.ContaPoupanca;

public class PessoaFisica extends Pessoa{

    public PessoaFisica(String nome){
        super(nome);
    }
    public PessoaFisica(){
    }
    @Override
    public void abrirConta(TipoDeConta tipo, BigDecimal rendimentos){
        super.abrirConta(tipo, BigDecimal.ZERO);
        if(tipo == TipoDeConta.CONTA_POUPANCA)
            setConta(new ContaPoupanca());
    }
}
