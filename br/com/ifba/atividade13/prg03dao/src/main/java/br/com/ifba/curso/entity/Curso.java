package br.com.ifba.curso.entity;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Representa a entidade Curso mapeada para o banco de dados.
 */
@Entity
@Table(name = "curso")
public class Curso extends PersistenceEntity {

    private String nome;
    private String codigo;

    // Construtor padrão exigido pelo JPA
    public Curso() {}

    // Construtor auxiliar para criar um novo curso rapidamente
    public Curso(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    // Getters e setters
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
