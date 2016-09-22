package br.ufg.mds.exercicio2.main;

import br.ufg.mds.compartilhado.EntradaConsole;
import br.ufg.mds.compartilhado.IteracaoUsuario;
import br.ufg.mds.exercicio2.model.Banco;
import br.ufg.mds.exercicio2.model.ContaCorrente;

import static java.lang.System.out;

public class Exercicio2Main {

    /**
     * Ponto de entrada principal, para execução do programa
     *
     * @param args Argumentos para execução. Não se aplica
     */
    public static void main(String[] args) {
        EntradaConsole entradaConsole = new EntradaConsole();
        String nomeTitular = entradaConsole.pergunteString("Informe o nome do titular da conta:", true);

        Banco banco = new Banco();
        ContaCorrente contaCorrente = banco.crieNovaConta(nomeTitular);

        out.println("Conta corrente criada com sucesso para: " + contaCorrente.getNomeTitular() + "\n");

        ExecutorOperacoesContaBancaria executorOperacoes = new ExecutorOperacoesContaBancaria(entradaConsole, contaCorrente);
        IteracaoUsuario iteracaoUsuario = new IteracaoUsuario(entradaConsole, executorOperacoes);
        iteracaoUsuario.execute();

        System.exit(0);
    }
}
