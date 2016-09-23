package br.ufg.mds.exercicio5.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Abstração de partida de bingo
 */
public class PartidaBingo {
    private List<Jogador> idosos;
    private int tamanhoLinhasCartelas;
    private int tamanhoColunasCartelas;
    private Jogador vencedor;
    private Stack<Integer> bolas;

    /**
     * Construtor da partida. Já carregando as possíveis bolas
     *
     * @param tamanhoLinhasCartelas  Quantidade de linhas das cartelas da partida
     * @param tamanhoColunasCartelas Quantidade de colunas das cartelas da partida
     */
    public PartidaBingo(int tamanhoLinhasCartelas, int tamanhoColunasCartelas) {
        this.tamanhoLinhasCartelas = tamanhoLinhasCartelas;
        this.tamanhoColunasCartelas = tamanhoColunasCartelas;
        idosos = new ArrayList<>();
        bolas = new Stack<>();

        // Carrega as possíveis opções de bolas para a partida
        for (int b = 1; b <= tamanhoColunasCartelas * Cartela.OPCOES_POR_COLUNA; b++) {
            bolas.push(b);
        }
    }

    /**
     * Insere um novo Jogador à partida e já atribui uma cartela do bingo
     *
     * @param nome Nome do jogador a ser inserido
     * @return O jogador inserido
     */
    public Jogador registreJogador(String nome) {
        Cartela cartela = new Cartela(tamanhoLinhasCartelas, tamanhoColunasCartelas);
        Jogador jogador = new Jogador(nome, cartela);

        idosos.add(jogador);

        return jogador;
    }

    /**
     * Realiza nova rodada
     *
     * @return O número sorteado
     */
    public int novaRodada() {
        // Embaralhando as opções
        Collections.shuffle(bolas);
        // Obtendo e removendo a bola sorteada
        Integer bola = bolas.pop();
        // Para cada jogador
        for (Jogador jogador : idosos) {
            // Solicitando registro de numero sorteado
            jogador.registreNumeroSorteado(bola);
            // Verificando se o jogador completou a cartela e salvando, caso verdadeiro
            if (jogador.verifiqueBingo()) {
                vencedor = jogador;
            }
        }
        return bola;
    }

    // Metodo acessor para obter o vencedor
    public Jogador getVencedor() {
        return vencedor;
    }
}
