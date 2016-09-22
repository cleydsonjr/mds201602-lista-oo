package br.ufg.mds.exercicio1;

/**
 * Encapsulamento de lógica para contagem de itens ou eventos
 */
public class Contador {
    private int valorAtual = 0;

    /**
     * Construtor que permite informar um valor inicial para o contador
     * @param valorInicial Valor inicial desejado para o contador
     */
    public Contador(int valorInicial) {
        this.valorAtual = valorInicial;
    }

    public Contador() {
        this(0);
    }

    /**
     * Método responsável por zerar o contador. Voltando o valor atual para zero
     */
    void zere() {
        this.valorAtual = 0;
    }

    /**
     * Método responsável por incrementar o valor atual em uma unidade
     * @return O valor atual já incrementado
     */
    int incremente() {
        return this.valorAtual++;
    }

    /**
     * Método que torna o valor atual do contador acessível
     * @return O valor atual do contador
     */
    public int getValorAtual() {
        return valorAtual;
    }
}
