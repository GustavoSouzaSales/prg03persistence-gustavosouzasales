package br.com.ifba.curso.dao;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.dao.GenericDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

/**
 * Implementa o DAO específico da entidade Curso.
 * Usa o GenericDao para CRUD básico e adiciona a busca por código.
 */
public class CursoDao extends GenericDao<Curso> implements CursoIDao {

    @Override
    public Curso buscarPorCodigo(String codigo) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            // consulta JPQL que busca o curso com o código informado.
            String jpql = "SELECT c FROM Curso c WHERE c.codigo = :codigo";
            
            // executa a consulta e retorna o resultado único.
            return entityManager.createQuery(jpql, Curso.class)
                    .setParameter("codigo", codigo)
                    .getSingleResult();

        } catch (NoResultException e) {
            // retorna null se não encontrar nenhum curso com o código.
            return null;
        } catch (Exception e) {
            // exibe o erro caso ocorra algum problema na consulta.
            System.err.println("Erro ao buscar curso por código: " + e.getMessage());
            return null;
        } finally {
            // fecha o EntityManager para liberar recursos.
            entityManager.close();
        }
    }
}
