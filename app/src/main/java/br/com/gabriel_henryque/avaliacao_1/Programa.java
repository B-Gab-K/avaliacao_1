package br.com.gabriel_henryque.avaliacao_1;

public class Programa {
    private String nome;
    private String vagas;

    public Programa(String nome, String vagas) {
        this.nome = nome;
        this.vagas = vagas;
    }

    public String getNome() {
        return nome;
    }

    public String getVagas() {
        return vagas;
    }
}
