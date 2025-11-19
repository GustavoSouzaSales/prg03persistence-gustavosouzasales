package br.com.ifba.curso.service;

import br.com.ifba.curso.entity.Curso;
import java.util.List;

public interface CursoIService {

    Curso salvar(Curso curso);
    Curso atualizar(Curso curso);
    void deletar(Curso curso);

    List<Curso> listarTodos();

    Curso buscarPorId(Long id);
    Curso buscarPorNome(String nome);
    Curso buscarPorCodigo(String codigo); 
}
