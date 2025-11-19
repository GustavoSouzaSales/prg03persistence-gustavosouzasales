package br.com.ifba.curso.repository;

import br.com.ifba.curso.entity.Curso;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    
    // herda de JpaRepositoy, onde já fornece metodos prontos pra trabalharem no banco de dados.

    // Buscar pelo nome
    @Query("SELECT c FROM Curso c WHERE c.nome = :nome")
    Optional<Curso> buscarPorNome(String nome);

    // Buscar pelo código
    @Query("SELECT c FROM Curso c WHERE c.codigo = :codigo")
    Optional<Curso> buscarPorCodigo(String codigo);
}
