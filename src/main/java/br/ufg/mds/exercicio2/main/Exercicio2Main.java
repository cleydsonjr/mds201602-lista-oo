package br.ufg.mds.exercicio2.main;

import br.ufg.mds.compartilhado.EntradaConsole;
import br.ufg.mds.compartilhado.IteracaoUsuario;
import br.ufg.mds.exercicio2.model.Banco;
import br.ufg.mds.exercicio2.model.ContaCorrente;

import java.text.NumberFormat;
import java.util.Locale;

import static java.lang.System.out;

public class Exercicio2Main {

    public static void main(String[] args) {
        EntradaConsole entradaConsole = new EntradaConsole();
        String nomeTitular = entradaConsole.pergunteString("Informe o nome do titular da conta:", true);

        Banco banco = new Banco();
        ContaCorrente contaCorrente = banco.crieNovaConta(nomeTitular);

        out.println("Conta corrente criada com sucesso para: " + contaCorrente.getNomeTitular() + "\n");
        ExecutorOperacoesContaBancaria executorOperacoes = new ExecutorOperacoesContaBancaria(entradaConsole, contaCorrente);
        IteracaoUsuario iteracaoUsuario = new IteracaoUsuario(entradaConsole, executorOperacoes);
        int opcao = -1;
        while (opcao != 0) {
            opcao = iteracaoComUsuario(entradaConsole, contaCorrente);
        }

        out.println("Obrigado.");
        System.exit(0);
    }

    private static int iteracaoComUsuario(EntradaConsole entradaConsole, ContaCorrente contaCorrente) {
        out.println("Operações disponíveis:");
        out.println("1. Realizar depósito");
        out.println("2. Realizar saque");
        out.println("3. Recuperar saldo");
        out.println("0. Encerrar\n");

        int opcao = entradaConsole.pergunteInteiro("Entre o número da operação desejada:");
        trateOpcaoEscolhida(entradaConsole, contaCorrente, opcao);
        out.println();

        return opcao;
    }

    private static void trateOpcaoEscolhida(EntradaConsole entradaConsole, ContaCorrente contaCorrente, int opcao) {
        Locale locale = new Locale("pt", "BR");
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);

        switch (opcao) {
            case 1:
                double valorDeposito = entradaConsole.pergunteDouble("Informe o valor do depósito:");

                try {
                    contaCorrente.realizeDeposito(valorDeposito);
                    out.println("Depósito realizado com sucesso");
                } catch (IllegalArgumentException ex) {
                    System.err.println(ex.getMessage());
                }

                break;
            case 2:
                double valorSaque = entradaConsole.pergunteDouble("Informe o valor do saque:");

                try {
                    boolean saqueRealizado = contaCorrente.realizeSaque(valorSaque);

                    if (saqueRealizado) {
                        out.println("Saque realizado com sucesso.");
                    } else {
                        out.println("Saldo insuficiente.");
                    }
                } catch (IllegalArgumentException ex) {
                    System.err.println(ex.getMessage());
                }

                break;
            case 3:
                out.print("Saldo disponivel em conta: ");
                Double saldoConta = contaCorrente.getSaldo();
                String saldoFormatado = format.format(saldoConta);
                out.println(saldoFormatado);
                break;
            case 0:
                break;
            default:
                out.println("Entrada inválida. Tente novamente");
                break;
        }
    }

}
