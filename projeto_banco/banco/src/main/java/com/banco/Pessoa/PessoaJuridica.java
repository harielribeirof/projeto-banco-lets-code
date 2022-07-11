package com.banco.Pessoa;

import java.math.BigDecimal;

public class PessoaJuridica extends Pessoa{
    public PessoaJuridica(String nome){
        super(nome);
    }
    public PessoaJuridica(){
     
    }

    @Override
    public void abrirConta(TipoDeConta tipo, BigDecimal rendimentos){
        super.abrirConta(tipo, new BigDecimal("0.02"));
        this.getConta().setTaxa(new BigDecimal("0.005"));
        
    }
}
