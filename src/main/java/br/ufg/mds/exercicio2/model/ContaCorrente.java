package br.ufg.mds.exercicio2.model;

/**
 * Classe responsável pela abstração de uma conta corrente bancária.
 */
public class ContaCorrente {
    /**
     * Nome do titular da conta
     */
    private String nomeTitular;

    /**
     * Montante contido na conta
     */
    private Double saldo;

    /**
     * Construtor da conta conrrente, solicita o fornecimento do nome do titular
     *
     * @param nomeTitular Nome do titular para a conta
     */
    public ContaCorrente(String nomeTitular) {
        this.nomeTitular = nomeTitular;
        this.saldo = 0d;
    }

    /**
     * Método responsável por realizar saque na conta corrente. Diminuindo o saldo disponível
     * Realiza uma validação para verificar se o montante solicitado está disponível na conta.
     *
     * @param valor Montante do saque a ser realizado - Obrigatoriamente maior que zero
     * @return O resultado do saque
     */
    public boolean realizeSaque(Double valor) {
        // Verificando se o valor informado é válido
        valideValorInformado(valor);

        // Verificando se o saldo cobre o valor solicitado para saque
        if (saldo >= valor) {
            // Subtraindo o valor solicitado do saldo da conta
            saldo -= valor;
            return true;
        } else {
            // O valor solicitado é maior que o saldo da conta
            return false;
        }
    }

    /**
     * Método responsável por realizar depósito na conta
     *
     * @param valor O montante a ser depositado na conta - Obrigatoriamente maior que zero
     * @return
     */
    public Double realizeDeposito(Double valor) {
        // Verificando se o valor informado é válido
        valideValorInformado(valor);

        // Incrementando o saldo com valor informado
        saldo += valor;

        // Retornando novo saldo da conta
        return saldo;
    }

    private void valideValorInformado(Double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido informado");
        }
    }

    // Método acessor para o saldo da conta
    public Double getSaldo() {
        return saldo;
    }

    // Método acessor para o nome do titular da conta
    public String getNomeTitular() {
        return nomeTitular;
    }
}
