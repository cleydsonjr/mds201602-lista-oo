package br.ufg.mds.exercicio5.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Cartela de um jogador de bingo
 */
public class Cartela {
    public static final int OPCOES_POR_COLUNA = 15;

    private List<Integer> numeros;

    /**
     * Nova cartela já preenchendo os números aleatoriamente
     *
     * @param linhas  Quantidade de linhas
     * @param colunas Quantidade de colunas
     */
    public Cartela(int linhas, int colunas) {
        this.numeros = new ArrayList<>();

        sorteieNumeros(linhas, colunas);
    }

    private void sorteieNumeros(int linhas, int colunas) {
        for (int c = 1; c <= colunas; c++) {
            int minColuna = (c - 1) * OPCOES_POR_COLUNA + 1;
            int maxColuna = c * OPCOES_POR_COLUNA;

            // Montando possíveis números para a coluna
            List<Integer> opcoes = new ArrayList<>();
            for (int n = minColuna; n <= maxColuna; n++) {
                opcoes.add(n);
            }

            // Embaralhando numeros
            Collections.shuffle(opcoes);

            // Preenchendo coluna. Um numero por linha
            for (int l = 0; l < linhas; l++) {
                numeros.add(opcoes.get(l));
            }
        }
    }

    /**
     * Veirifica se a cartela contem o numero sorteado
     *
     * @param numeroSorteado O numero sorteado
     * @return Se o numero está contido na cartela
     */
    boolean verifiqueNumero(int numeroSorteado) {
        return numeros.contains(numeroSorteado);
    }

    /**
     * Quantidade de numeros da parcela
     *
     * @return Quantidade de numeros
     */
    int quantidadeNumeros() {
        return numeros.size();
    }

    public String toString() {
        return Arrays.toString(numeros.toArray());
    }
}
