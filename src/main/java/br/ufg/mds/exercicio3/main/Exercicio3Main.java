package br.ufg.mds.exercicio3.main;

import br.ufg.mds.compartilhado.EntradaConsole;
import br.ufg.mds.compartilhado.IteracaoUsuario;
import br.ufg.mds.exercicio3.model.DataSimples;

public class Exercicio3Main {

    /**
     * Ponto de entrada principal, para execução do programa
     *
     * @param args Argumentos para execução. Não se aplica
     */
    public static void main(String[] args) {
        EntradaConsole entradaConsole = new EntradaConsole();
        DataSimples dataSimples = new DataSimples();

        ExecutorOperacoesDataSimples executorOperacoes = new ExecutorOperacoesDataSimples(entradaConsole, dataSimples);
        IteracaoUsuario iteracaoUsuario = new IteracaoUsuario(entradaConsole, executorOperacoes);
        iteracaoUsuario.execute();

        System.exit(0);
    }
}
