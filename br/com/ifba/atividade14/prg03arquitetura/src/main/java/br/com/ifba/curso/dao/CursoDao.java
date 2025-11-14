package br.com.ifba.curso.dao;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.dao.GenericDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class CursoDao extends GenericDao<Curso> implements CursoIDao {

    @Override
    public Curso buscarPorNome(String nome) {

        // Abre uma conexão com o banco.
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            // Cria uma consulta pra procurar curso pelo nome.
            TypedQuery<Curso> query = entityManager.createQuery(
                "SELECT c FROM Curso c WHERE c.nome = :nome", Curso.class
            );
            query.setParameter("nome", nome);

            return query.getSingleResult();

        } catch (NoResultException e) {
            // nenhum curso encontrado
            return null;

        } catch (Exception e) { // Se deu algum erro inesperado, só mostra no console pra debug.
            System.err.println("Erro ao buscar curso por nome: " + e.getMessage());
            return null;

        } finally { // Fecha a conexão com o banco.
            entityManager.close();
        }
    }

    @Override
    public Curso buscarPorId(Long id) { // Aqui a gente só aproveita o método já pronto da classe genérica.
        return super.buscarPorId(id);
    }
}
