package com.nazax.crud.models;

import jakarta.persistence.*;

@Entity // Diz que essa classe é uma entidade do banco
@Table(name = "cidades") // Especifica o nome da tabela no banco
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera o ID automaticamente no banco
    private Long id;

    private String nome;
    private String cep;

    // Construtores
    public Cidade() {}

    public Cidade(Long id, String nome, String cep) {
        this.id = id;
        this.nome = nome;
        this.cep = cep;
    }

    // Getters e Setters (usados para acessar e modificar os atributos)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }
}

