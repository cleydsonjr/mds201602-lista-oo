package br.ufg.mds.exercicio5.main;

import br.ufg.mds.compartilhado.EntradaConsole;
import br.ufg.mds.exercicio5.model.Jogador;
import br.ufg.mds.exercicio5.model.PartidaBingo;

import static java.lang.System.out;

public class Exercicio5Main {

    /**
     * Ponto de entrada principal, para execução do programa
     *
     * @param args Argumentos para execução. Não se aplica
     */
    public static void main(String[] args) {
        try {
            EntradaConsole entradaConsole = new EntradaConsole();
            PartidaBingo partidaBingo = new PartidaBingo(3, 3);

            String nomeJogador = entradaConsole.pergunteString("Informe seu nome:", true);
            Jogador jogador = partidaBingo.registreJogador(nomeJogador);
            out.println("Sua Cartela:");
            out.println(jogador.getCartela());
            out.println();

            Jogador computador = partidaBingo.registreJogador("Computador");
            out.println("Cartela Computador: ");
            out.println(computador.getCartela());
            out.println();
            out.println();
            out.println("Iniciando sorteio!");
            Thread.sleep(2000);

            int rodada = 1;
            while (partidaBingo.getVencedor() == null) {
                out.println("=== RODADA " + rodada + " ===");
                int bolaSorteada = partidaBingo.novaRodada();
                out.println("Bola sorteada:" + bolaSorteada);

                out.println();
                out.println("Acertos Jogador: " + jogador.getAcertos());
                out.println("Acertos Computador: " + computador.getAcertos());
                out.println();

                Thread.sleep(1000);
                rodada++;
            }

            out.println("BINGO!");
            out.println("Vencedor: " + partidaBingo.getVencedor());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
