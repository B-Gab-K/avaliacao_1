package br.com.gabriel_henryque.avaliacao_1;

public class Programa {
    private String nome;
    private String vagas;
    private String data;

    public Programa(String nome, String vagas, String data) {
        this.nome = nome;
        this.vagas = vagas;
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public String getVagas() {
        return vagas;
    }

    public String getData() {
        return data;
    }
}
