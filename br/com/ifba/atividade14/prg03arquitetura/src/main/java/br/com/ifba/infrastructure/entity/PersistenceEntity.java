package br.com.ifba.infrastructure.entity;

import jakarta.persistence.GeneratedValue;      // indica que o valor do ID será gerado automaticamente.
import jakarta.persistence.GenerationType;      // define a estratégia usada para gerar o ID.
import jakarta.persistence.Id;                  // marca o campo como chave primária da tabela.
import jakarta.persistence.MappedSuperclass;    // indica que esta classe será herdada por outras entidades JPA.


@MappedSuperclass // indica que esta classe não é uma tabela, mas suas propriedades serão herdadas por outras entidades.
public class PersistenceEntity {

    /**
     * Campo que representa a chave primária (Primary Key) da entidade.
     * 
     * @Id -> Diz ao JPA que este é o identificador único da tabela.
     * 
     * @GeneratedValue(strategy = GenerationType.IDENTITY)
     *    -> Indica que o banco (no caso, o MySQL) será responsável por gerar
     *       automaticamente o valor do ID (campo AUTO_INCREMENT).
     * 
     *    A estratégia IDENTITY é recomendada para MySQL,
     *    pois usa a funcionalidade nativa de incremento automático do banco,
     *    evitando a criação de tabelas auxiliares de sequência.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // tipo "Long" permite valores nulos antes do objeto ser salvo.

    // Getter e Setter.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
