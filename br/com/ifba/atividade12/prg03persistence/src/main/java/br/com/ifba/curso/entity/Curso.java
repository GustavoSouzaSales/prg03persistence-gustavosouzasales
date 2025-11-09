package br.com.ifba.curso.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


 //Representa a entidade Curso mapeada para o banco de dados.
 
@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String codigo;

    // construtor padrão exigido pelo JPA
    public Curso() {}

    // construtor auxiliar para criar um novo curso rapidamente.
    public Curso(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    // getters e setters.
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
