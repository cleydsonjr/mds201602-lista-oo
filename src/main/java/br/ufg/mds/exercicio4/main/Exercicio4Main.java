package br.ufg.mds.exercicio4.main;

import br.ufg.mds.compartilhado.EntradaConsole;
import br.ufg.mds.exercicio4.model.Agenda;

import static java.lang.System.out;

public class Exercicio4Main {

    /**
     * Ponto de entrada principal, para execução do programa
     *
     * @param args Argumentos para execução. Não se aplica
     */
    public static void main(String[] args) {
        EntradaConsole entradaConsole = new EntradaConsole();
        Agenda agenda = new Agenda();

        while (agenda.getQuantidadeContatos() < 10) {
            String nome = entradaConsole.pergunteString("Informe o nome do contato:");
            String telefone = entradaConsole.pergunteString("Informe o número do telefone:");
            Boolean adicionado = agenda.adicioneContato(nome, telefone);

            if (adicionado) {
                out.println("Contato adicionado.");
            } else {
                out.println("Informações inválidas");
            }
        }

        System.exit(0);
    }
}
