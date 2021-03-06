package br.ufg.mds.compartilhado;

import java.util.Map;

import static java.lang.System.out;

/**
 * Classe auxiliar para encapsulamento da lógica de disponibilização de opções de operações para o usuário
 */
public class IteracaoUsuario {
    private ExecutorOperacoes executorOperacoes;
    private EntradaConsole entradaConsole;

    public IteracaoUsuario(EntradaConsole entradaConsole, ExecutorOperacoes executorOperacoes) {
        this.entradaConsole = entradaConsole;
        this.executorOperacoes = executorOperacoes;
    }

    /**
     * Realiza a iteração com o usuário exibindo as opções disponíveis.
     */
    public void execute() {
        int opcao = -1;
        while (opcao != 0) {
            exibaOpcoes();

            opcao = entradaConsole.pergunteInteiro("Entre o número da operação desejada:");
            if (opcao != 0) {
                executorOperacoes.execute(opcao);
            }
            out.println();
        }

        out.println("Obrigado.");
    }

    private void exibaOpcoes() {
        out.println("Operações disponíveis:");

        Map<Integer, String> opcoes = executorOperacoes.getOpcoes();
        opcoes.forEach((opcao, descricao) -> {
            out.println("\t" + opcao + ". " + descricao);
        });

        out.println("\t0. Encerrar\n");
    }
}
