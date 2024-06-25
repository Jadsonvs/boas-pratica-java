package br.com.alura.domain;

public class Pet {

    private Long id;
    private String nome;
    private int idade;
    private String tipo;
    private String raca;
    private String cor;
    private Float peso;

    public Pet(String nome, int idade, String tipo, String raca, String cor, Float peso) {
        this.nome = nome;
        this.idade = idade;
        this.tipo = tipo;
        this.raca = raca;
        this.cor = cor;
        this.peso = peso;
    }

    public Long getId() { return id; }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getTipo() {
        return tipo;
    }

    public String getRaca() {
        return raca;
    }

}
