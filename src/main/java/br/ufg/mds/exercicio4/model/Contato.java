package br.ufg.mds.exercicio4.model;

public class Contato {
    public static final int MAX_TELEFONE = 11;
    public static final int MIN_TELEFONE = 10;

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

        // Verifica se o o nome foi informado
        if (nome == null || nome.isEmpty()) {
            valido = false;
        }

        try {
            if (telefone == null || telefone.length() < MIN_TELEFONE || telefone.length() > MAX_TELEFONE) {
                valido = false;
            } else {
                Long.parseLong(telefone);
            }
        } catch (NumberFormatException ignored) {
            valido = false;
        }

        return valido;
    }
}
