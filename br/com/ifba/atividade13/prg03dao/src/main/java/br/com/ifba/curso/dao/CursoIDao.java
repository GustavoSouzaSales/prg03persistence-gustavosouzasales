package br.com.ifba.curso.dao;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.dao.GenericIDao;

/**
 * Interface específica para a entidade Curso.
 * Herda os métodos genéricos de GenericIDao e adiciona operações específicas.
 */
public interface CursoIDao extends GenericIDao<Curso> {
    
    /**
     * Busca um curso no banco pelo seu código.
     * @param codigo código do curso a ser buscado
     * @return o Curso encontrado ou null, caso não exista
     */
    public abstract Curso buscarPorCodigo(String codigo);
}
