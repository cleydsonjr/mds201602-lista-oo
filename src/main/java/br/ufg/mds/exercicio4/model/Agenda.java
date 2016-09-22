package br.ufg.mds.exercicio4.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstração de Agenda
 */
public class Agenda {
    private List<Contato> contatos;

    public Agenda() {
        contatos = new ArrayList<>();
    }

    /**
     * Método para inserir um contato na agenda, validando as informações.
     *
     * @param nome     Nome do contato
     * @param telefone Número de 11 dígitos do telefone
     * @return Se é válido ou não
     */
    public Boolean adicioneContato(String nome, String telefone) {
        Boolean contatoValido;
        Contato contato = new Contato(nome, telefone);
        contatoValido = contato.valide();

        // Se o contato é válido, adicione
        if (contatoValido) {
            contatos.add(contato);
        }

        return contatoValido;
    }

    public int getQuantidadeContatos() {
        return contatos.size();
    }
}
