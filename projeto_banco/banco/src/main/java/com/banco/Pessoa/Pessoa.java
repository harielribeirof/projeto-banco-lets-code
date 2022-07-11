package com.banco.Pessoa;

import java.math.BigDecimal;

import com.banco.Conta.Conta;
import com.banco.Conta.ContaCorrente;
import com.banco.Conta.ContaInvestimento;

public class Pessoa {
    private String nome;
    private Conta conta;

    public Pessoa(String nome){
        this.nome = nome;
    }
    public Pessoa(){
        
    }

    public void abrirConta(TipoDeConta tipo, BigDecimal rendimentos){
        switch (tipo) {
            case CONTA_CORRENTE:
                this.conta = new ContaCorrente();
                break;
            case CONTA_INVESTIMENTO:
                this.conta = new ContaInvestimento(rendimentos);
                break;
            default:
                break;
        } 
    }

    public enum TipoDeConta{
        CONTA_CORRENTE,
        CONTA_POUPANCA,
        CONTA_INVESTIMENTO;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Conta getConta() {
        return this.conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
