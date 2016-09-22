package br.ufg.mds.exercicio2.main;

import br.ufg.mds.compartilhado.EntradaConsole;
import br.ufg.mds.compartilhado.ExecutorOperacoes;
import br.ufg.mds.exercicio2.model.ContaCorrente;

import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import static java.lang.System.out;

public class ExecutorOperacoesContaBancaria implements ExecutorOperacoes {
    private Map<Integer, String> opcoes;
    private EntradaConsole entradaConsole;
    private ContaCorrente contaCorrente;
    private NumberFormat format;

    public ExecutorOperacoesContaBancaria(EntradaConsole entradaConsole, ContaCorrente contaCorrente) {
        this.entradaConsole = entradaConsole;
        this.contaCorrente = contaCorrente;

        Locale locale = new Locale("pt", "BR");
        format = NumberFormat.getCurrencyInstance(locale);

        opcoes = new LinkedHashMap<>();
        opcoes.put(1, "Realizar depósito");
        opcoes.put(2, "Realizar saque");
        opcoes.put(3, "Recuperar saldo");
    }

    public Map<Integer, String> getOpcoes() {
        return opcoes;
    }

    public void execute(Integer opcao) {
        switch (opcao) {
            case 1:
                realizarDeposito();
                break;
            case 2:
                realizarSaque();
                break;
            case 3:
                consultarSaldo();
                break;
            case 0:
                break;
            default:
                out.println("Entrada inválida. Tente novamente");
                break;
        }
    }

    private void consultarSaldo() {
        out.print("Saldo disponivel em conta: ");
        Double saldoConta = contaCorrente.getSaldo();
        String saldoFormatado = format.format(saldoConta);
        out.println(saldoFormatado);
    }

    private void realizarSaque() {
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
    }

    private void realizarDeposito() {
        double valorDeposito = entradaConsole.pergunteDouble("Informe o valor do depósito:");

        try {
            contaCorrente.realizeDeposito(valorDeposito);
            out.println("Depósito realizado com sucesso");
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
