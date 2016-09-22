package br.ufg.mds.compartilhado;

import java.util.Map;

/**
 * Abstração da implementação da lógica de operação por número de opção selecionado pelo usuário
 */
public interface ExecutorOperacoes {

    void execute(Integer numeroSelecionado);

    Map<Integer, String> getOpcoes();

}
