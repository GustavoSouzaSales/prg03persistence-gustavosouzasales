package br.com.ifba.curso.controller;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.service.CursoIService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CursoController implements CursoIController {

    
    // aqui tem as regras de negócio, só que sem acoplamento.
    @Autowired
    private CursoIService service;

    @Override
    public Curso salvar(Curso curso) {
        return service.salvar(curso);
    }

    @Override
    public Curso atualizar(Curso curso) {
        return service.atualizar(curso);
    }

    @Override
    public void deletar(Curso curso) {
        service.deletar(curso);
    }

    @Override
    public List<Curso> listarTodos() {
        return service.listarTodos();
    }

    @Override
    public Curso buscarPorId(Long id) {
        return service.buscarPorId(id);
    }

    @Override
    public Curso buscarPorNome(String nome) {
        return service.buscarPorNome(nome);
    }

    @Override
    public Curso buscarPorCodigo(String codigo) {
        return service.buscarPorCodigo(codigo);
    }
}
