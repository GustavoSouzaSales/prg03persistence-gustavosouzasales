package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Classe genérica que realiza operações básicas de CRUD.
 * @param <Entity> entidade que estende PersistenceEntity
 */
public class GenericDao<Entity extends PersistenceEntity> implements GenericIDao<Entity> {

    // cria a fábrica de EntityManagers com base na unidade de persistência.
    protected static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("cursoPU");

    // salva um novo registro no banco.
    @Override
    public Entity salvar(Entity entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.err.println("Erro ao salvar entidade: " + e.getMessage());
            throw e;
        } finally {
            entityManager.close();
        }
    }

    // atualiza um registro existente.
    @Override
    public Entity atualizar(Entity entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.err.println("Erro ao atualizar entidade: " + e.getMessage());
            throw e;
        } finally {
            entityManager.close();
        }
    }

    // exclui um registro do banco.
    @Override
    public void excluir(Entity entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Entity entityAnexada = entityManager.merge(entity);
            entityManager.remove(entityAnexada);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.err.println("Erro ao excluir entidade: " + e.getMessage());
            throw e;
        } finally {
            entityManager.close();
        }
    }

    // retorna todos os registros da entidade.
    @Override
    @SuppressWarnings("unchecked")
    public List<Entity> listarTodos() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.createQuery("FROM " + getTypeClass().getName()).getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao listar entidades: " + e.getMessage());
            return null;
        } finally {
            entityManager.close();
        }
    }

    // busca um registro pelo ID.
    @Override
    @SuppressWarnings("unchecked")
    public Entity buscarPorId(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return (Entity) entityManager.find(getTypeClass(), id);
        } finally {
            entityManager.close();
        }
    }

    // retorna a classe da entidade concreta.
    protected Class<?> getTypeClass() {
        return (Class<?>) ((ParameterizedType) getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
    }
}
