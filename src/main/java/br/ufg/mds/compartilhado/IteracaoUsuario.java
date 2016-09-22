package br.ufg.mds.compartilhado;

import java.util.Map;

import static java.lang.System.out;

public class IteracaoUsuario {
    private Map<Integer, String> opcoes;
    private ExecutorOperacoes executorOperacoes;
    private EntradaConsole entradaConsole;

    public IteracaoUsuario(EntradaConsole entradaConsole, ExecutorOperacoes executorOperacoes) {
        this.entradaConsole = entradaConsole;
        this.executorOperacoes = executorOperacoes;
    }

    void execute() {
        int opcao = -1;
        while (opcao != 0) {
            opcao = iteracaoComUsuario();
        }
    }

    private int iteracaoComUsuario() {
        out.println("Operações disponíveis:");
        out.println("1. Realizar depósito");
        out.println("2. Realizar saque");
        out.println("3. Recuperar saldo");
        out.println("0. Encerrar\n");

        int opcao = entradaConsole.pergunteInteiro("Entre o número da operação desejada:");
        executorOperacoes.execute(opcao);
        out.println();

        return opcao;
    }
}
