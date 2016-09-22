package br.ufg.mds.exercicio3.main;

import br.ufg.mds.compartilhado.EntradaConsole;
import br.ufg.mds.compartilhado.ExecutorOperacoes;
import br.ufg.mds.exercicio3.model.DataSimples;

import java.util.LinkedHashMap;
import java.util.Map;

import static java.lang.System.out;

public class ExecutorOperacoesDataSimples implements ExecutorOperacoes {
    private Map<Integer, String> opcoes;
    private EntradaConsole entradaConsole;
    private DataSimples dataSimples;

    public ExecutorOperacoesDataSimples(EntradaConsole entradaConsole, DataSimples dataSimples) {
        this.entradaConsole = entradaConsole;
        this.dataSimples = dataSimples;

        opcoes = new LinkedHashMap<>();
        opcoes.put(1, "Informar dia");
        opcoes.put(2, "Informar mês");
        opcoes.put(3, "Informar ano");
        opcoes.put(4, "Visualizar data");
    }

    public Map<Integer, String> getOpcoes() {
        return opcoes;
    }

    public void execute(Integer opcao) {
        switch (opcao) {
            case 1:
                informarDia();
                break;
            case 2:
                informarMes();
                break;
            case 3:
                informarAno();
                break;
            case 4:
                visualizarData();
                break;
            default:
                out.println("Entrada inválida. Tente novamente");
                break;
        }
    }

    private void informarDia() {
        try {
            Integer dia = entradaConsole.pergunteInteiro("Informe o dia:");
            dataSimples.setDia(dia);
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void informarMes() {
        try {
            Integer mes = entradaConsole.pergunteInteiro("Informe o mês:");
            dataSimples.setMes(mes);
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void informarAno() {
        try {
            Integer ano = entradaConsole.pergunteInteiro("Informe o ano:");
            dataSimples.setAno(ano);
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void visualizarData() {
        String data = dataSimples.toString();
        out.println(data);
    }
}
