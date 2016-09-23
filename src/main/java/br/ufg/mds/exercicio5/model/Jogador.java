package br.ufg.mds.exercicio5.model;

/**
 * Abstração de um jogador de bingo, registrando a cartela e o numero de acertos
 */
public class Jogador {
    private String nome;
    private int acertos;
    private Cartela cartela;

    /**
     * @param nome    Nome do jogador
     * @param cartela Cartela do jogador
     */
    public Jogador(String nome, Cartela cartela) {
        this.nome = nome;
        this.cartela = cartela;
        this.acertos = 0;
    }

    /**
     * Verifica se o jogador possui o numero sorteado
     *
     * @param numeroSorteado Numero para verificar
     */
    public void registreNumeroSorteado(int numeroSorteado) {
        if (cartela.verifiqueNumero(numeroSorteado)) {
            acertos++;
        }
    }

    /**
     * Verifica se o jogador acertou todos os numeros de sua cartela
     *
     * @return Se foi bingo
     */
    public boolean verifiqueBingo() {
        return acertos == cartela.quantidadeNumeros();
    }

    public int getAcertos() {
        return acertos;
    }

    public Cartela getCartela() {
        return cartela;
    }

    public String toString() {
        return nome;
    }
}
