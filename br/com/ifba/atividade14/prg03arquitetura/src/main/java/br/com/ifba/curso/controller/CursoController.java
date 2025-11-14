package br.com.ifba.curso.controller;

import br.com.ifba.curso.dao.CursoDao;
import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.service.CursoIService;
import br.com.ifba.curso.service.CursoService;
import java.util.List;

public class CursoController implements CursoIController {

    private final CursoIService service;

    // Construtor padrão.
    public CursoController() {
        this.service = new CursoService(new CursoDao());
    }

    public CursoController(CursoIService service) {
        this.service = service;
    }

    @Override
    public Curso salvar(Curso curso) { // Só repassa pro service salvar
        return service.salvar(curso);
    }

    @Override
    public Curso atualizar(Curso curso) { // Atualiza o curso no banco
        return service.atualizar(curso);
    }

    @Override
    public void deletar(Curso curso) { // Remove o curso do banco
        service.deletar(curso);
    }

    @Override
    public List<Curso> listarTodos() { // Retorna tudo que tem cadastrado
        return service.listarTodos();
    }
    
    @Override
    public Curso buscarPorId(Long id) { 

        if (id == null) {
            throw new RuntimeException("ID não pode ser nulo!"); // Não tem como buscar um ID que não existe.
        }

        return service.buscarPorId(id); // Chama o service e pega o curso
    }

    @Override
    public Curso buscarPorNome(String nome) { // Busca um curso pelo nome.
        return service.buscarPorNome(nome);
    }
}
