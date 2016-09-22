package br.ufg.mds.exercicio2.model;

/**
 * Abstração de um Banco
 */
public class Banco {

    /**
     * Encapsulamento de lógica para criação de uma nova conta corretne
     *
     * @param nomeTitular O nome do titular da conta
     * @return A conta corrente recém criada
     */
    public ContaCorrente crieNovaConta(String nomeTitular) {
        if (nomeTitular == null || nomeTitular.isEmpty()) {
            throw new IllegalArgumentException("O nome do titular é obrigatório");
        }
        return new ContaCorrente(nomeTitular);
    }

}
