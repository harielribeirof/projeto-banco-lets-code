package com.banco.Conta;

import java.math.BigDecimal;
import java.util.ArrayList;

public abstract class Conta {
    private static ArrayList<Conta> contas = new ArrayList<Conta>();
    private static int numAutomatico = 0;
    private int numero;
    private BigDecimal saldo;
    private BigDecimal taxa;

    public Conta(){
        this.numero = numAutomatico;
        this.saldo = BigDecimal.ZERO;
        this.taxa = BigDecimal.ZERO;
        contas.add(this);
        numAutomatico++;
    }

    public void sacar(BigDecimal valor){
        if (valor.compareTo(saldo) > 0) {
            System.out.println("\n--> Saldo indisponível! <--\n");
            return;
        }
        if (valor.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("\n--> Valor inválido! <--\n");
            return;
        }
        this.saldo = this.saldo.subtract(valor.add(valor.multiply(taxa)));
        //this.saldo -= valor + valor*taxa;
    }

    public void depositar(BigDecimal valor){
        if (valor.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("\n--> Valor inválido! <--\n");
            return;
        }
        this.saldo = this.saldo.add(valor.subtract(valor.multiply(taxa)));
        // this.saldo += valor - valor*taxa;
    }

    public void transferencia(int numero, BigDecimal valor){
        if (procurarConta(numero) == null)
            return;
        this.sacar(valor);
        procurarConta(numero).depositar(valor);
    }

    public static Conta procurarConta(int numero){
        try {
            return contas.get(numero);    
        } catch (Exception e) {
            System.out.println("\n--> Conta inexistente! <--\n");
            return null;
        }
    }

    public int getNumero() {
        return numero;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }

    public BigDecimal consultarSaldo() {
        return this.saldo.setScale(2);
    }

    public void investir(BigDecimal valor) {
    }
}
