package br.ufg.mds.exercicio4.model;

public class Contato {
    public static final int TAMANHO_PADRAO_TELEFONE = 11;

    private String nome;
    private String telefone;

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    Boolean valide() {
        Boolean valido = true;
        if (nome == null || nome.isEmpty()) {
            valido = false;
        }
        if (telefone == null || telefone.length() != TAMANHO_PADRAO_TELEFONE) {
            valido = false;
        }

        return valido;
    }
}
