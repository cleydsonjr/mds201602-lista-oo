package br.ufg.mds.exercicio2.model;

public class Banco {

    public ContaCorrente crieNovaConta(String nomeTitular) {
        return new ContaCorrente(nomeTitular);
    }

}
