package com.banco;

import java.math.BigDecimal;
import java.util.Scanner;

import com.banco.Conta.ContaInvestimento;
import com.banco.Pessoa.Pessoa;
import com.banco.Pessoa.PessoaFisica;
import com.banco.Pessoa.PessoaJuridica;
import com.banco.Pessoa.Pessoa.TipoDeConta;

public class App 
{
    public static void main( String[] args )
    {
        final Scanner sc = new Scanner(System.in);
        int opcaoCliente, opcaoConta, opcaoMenu;
        String nome;
        Pessoa pessoa = new Pessoa();

        PessoaFisica clienteFisico = new PessoaFisica("Hariel");
        PessoaJuridica clienteJuridico = new PessoaJuridica("João");

        clienteJuridico.abrirConta(TipoDeConta.CONTA_CORRENTE, BigDecimal.ZERO);
        clienteFisico.abrirConta(TipoDeConta.CONTA_POUPANCA, BigDecimal.ZERO);

        clienteFisico.getConta().depositar(new BigDecimal("500"));
        clienteJuridico.getConta().depositar(new BigDecimal("1000"));

        do {            
            System.out.println("Qual o tipo de cliente?");
            System.out.println("1 - Pessoa Física");
            System.out.println("2 - Pessoa Jurídica");
            opcaoCliente = sc.nextInt();

            switch (opcaoCliente) {
                case 1:
                    System.out.println("Digite o nome do cliente: ");
                    nome = sc.next();
                    pessoa = new PessoaFisica(nome);
                    break;
                case 2:
                    System.out.println("Digite o nome do cliente: ");
                    nome = sc.next();
                    pessoa = new PessoaJuridica(nome);
                    break;
                default:
                    System.out.println("Opção incorreta!");
                    break;
            }    
        } while (opcaoCliente > 2 || opcaoCliente < 1);
        
        do {
            System.out.println("Qual o tipo de conta deseja abrir?");
            
            System.out.println("1 - Conta Corrente");
            System.out.println("2 - Conta Investimento");
            if(opcaoCliente == 1)
                System.out.println("3 - Conta Poupança");
            opcaoConta = sc.nextInt();
            switch (opcaoConta) {
                case 1: 
                    pessoa.abrirConta(TipoDeConta.CONTA_CORRENTE, BigDecimal.ZERO);
                case 2:
                    pessoa.abrirConta(TipoDeConta.CONTA_INVESTIMENTO, BigDecimal.ZERO);
                    break;
                case 3:   
                    if (opcaoCliente == 1) 
                        pessoa.abrirConta(TipoDeConta.CONTA_POUPANCA, BigDecimal.ZERO);
                    else
                        System.out.println("Opção incorreta!");
                    break;
            
                default:
                    System.out.println("Opção incorreta!");
                    break;
            }
            
        } while (opcaoConta > 3 || opcaoConta < 1);
        
        do {
            
            System.out.println("------------------------------");
            System.out.println("\nCLIENTE: " + pessoa.getNome());
            System.out.println("CONTA: " + pessoa.getConta().getNumero() + "\n");
            System.out.println("------------------------------");
            System.out.println("1 - Consultar Saldo");
            System.out.println("2 - Sacar");
            System.out.println("3 - Depositar");
            System.out.println("4 - Transferência");
            if (pessoa.getConta().getClass() == ContaInvestimento.class)
                System.out.println("5 - Investir");
            
            System.out.println("\n6 - SAIR");
            System.out.println("------------------------------");
            opcaoMenu = sc.nextInt();

            switch (opcaoMenu) {
                case 1:
                    System.out.println("\n SALDO: " + pessoa.getConta().consultarSaldo() + "\n");
                    break;
                case 2:
                    BigDecimal valor;
                    System.out.print("Digite o valor: ");
                    valor = sc.nextBigDecimal();
                    pessoa.getConta().sacar(valor);
                    break;
                case 3:
                    System.out.print("Digite o valor: ");
                    valor = sc.nextBigDecimal();
                    pessoa.getConta().depositar(valor);
                    break;
                case 4:
                    int numeroConta;
                    System.out.print("Digite o valor: ");
                    valor = sc.nextBigDecimal();
                    System.out.print("Digite o número da conta: ");
                    numeroConta = sc.nextInt();
                    pessoa.getConta().transferencia(numeroConta, valor);
                    break;
                case 5:
                    System.out.print("Digite o valor: ");
                    valor = sc.nextBigDecimal();
                    pessoa.getConta().investir(valor);
                    break;
                case 6:
                    System.out.println("\nPROGRAMA FINALIZADO!\n");
                    break;                
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcaoMenu != 6);
        sc.close();
    }
}
