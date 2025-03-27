package com.nazax.crud.dtos;

public class CidadeDTO {
    private Long id;
    private String nome;
    private String cep;

    // Construtores
    public CidadeDTO() {}

    public CidadeDTO(Long id, String nome, String cep) {
        this.id = id;
        this.nome = nome;
        this.cep = cep;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }
}

