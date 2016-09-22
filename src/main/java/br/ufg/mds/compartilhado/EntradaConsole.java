package br.ufg.mds.compartilhado;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class EntradaConsole {
    private Scanner scanner = new Scanner(in);

    public Integer pergunteInteiro(String pergunta) {
        String entradaString = pergunteString(pergunta);

        boolean entradaValida = false;
        int entradaInteiro = 0;

        while (!entradaValida) {
            try {
                entradaInteiro = Integer.parseInt(entradaString);
                entradaValida = true;
            } catch (NumberFormatException ignored) {
                out.println("Entrada inválida. Tente novamente");
                entradaValida = false;
                entradaString = pergunteString(pergunta);
            }
        }

        return entradaInteiro;
    }

    public Double pergunteDouble(String pergunta) {
        String entradaString = pergunteString(pergunta);
        boolean entradaValida = false;
        double entradaDouble = 0;

        while (!entradaValida) {
            try {
                entradaDouble = Double.parseDouble(entradaString);
                entradaValida = true;
            } catch (NumberFormatException ignored) {
                out.println("Entrada inválida. Tente novamente");
                entradaValida = false;
                entradaString = pergunteString(pergunta);
            }
        }

        return entradaDouble;
    }

    public String pergunteString(String pergunta) throws NumberFormatException {
        out.println(pergunta);
        return scanner.nextLine();
    }

    public String pergunteString(String pergunta, boolean obrigarEntrada) throws NumberFormatException {
        String entrada = pergunteString(pergunta);

        if (obrigarEntrada) {
            while (entrada.trim().equals("")) {
                entrada = pergunteString(pergunta);
            }
        }

        return entrada;
    }
}
