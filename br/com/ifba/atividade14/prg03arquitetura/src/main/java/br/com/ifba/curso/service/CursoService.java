package br.com.ifba.curso.service;

import br.com.ifba.curso.dao.CursoIDao;
import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.util.StringUtil;
import java.util.List;

/**
 * Implementação das regras de negócio de Curso.
 */
public class CursoService implements CursoIService {

    private final CursoIDao cursoDao;

    public CursoService(CursoIDao cursoDao) { // Quando a classe nasce, já recebe o DAO pra poder mexer no banco.
        this.cursoDao = cursoDao;
    }

    @Override
    public Curso salvar(Curso curso) {
        if (StringUtil.isNullOrEmpty(curso.getNome())) {
            throw new RuntimeException("Nome do curso inválido!"); // Não deixa salvar curso sem nome.
        }
        if (StringUtil.isNullOrEmpty(curso.getCodigo())) {
            throw new RuntimeException("Código do curso inválido!");
        }
        
        // verifica se nome já existe
        Curso existentePorNome = cursoDao.buscarPorNome(curso.getNome());
        if (existentePorNome != null) {
            throw new RuntimeException("Já existe um curso com esse nome!");
        }
        
        // verifica se código já existe (mesmo sem buscarPorCodigo)
        for (Curso c : cursoDao.listarTodos()) {
            if (c.getCodigo().equalsIgnoreCase(curso.getCodigo())) {
                throw new RuntimeException("Já existe um curso com esse código!");
            }
        }
        
        return cursoDao.salvar(curso);  // Passa pro DAO salvar no banco.
    } 

    @Override
    public Curso atualizar(Curso curso) {
        
        if (StringUtil.isNullOrEmpty(curso.getNome()) ||
            StringUtil.isNullOrEmpty(curso.getCodigo())) {
            throw new RuntimeException("Nome e código não podem estar vazios!");
        }
        
        // valida nome repetido
        Curso existenteNome = cursoDao.buscarPorNome(curso.getNome());
            if (existenteNome != null && !existenteNome.getId().equals(curso.getId())) {
                throw new RuntimeException("Outro curso já usa esse nome!");
            }
            
            // valida código repetido
        for (Curso c : cursoDao.listarTodos()) {
            if (c.getCodigo().equalsIgnoreCase(curso.getCodigo())
                && !c.getId().equals(curso.getId())) {
                throw new RuntimeException("Outro curso já usa esse código!");
            }
        }
        
        
        
        return cursoDao.atualizar(curso);
    }

    @Override
    public void deletar(Curso curso) {
        cursoDao.excluir(curso);
    }

    @Override
    public List<Curso> listarTodos() {
        return cursoDao.listarTodos();
    }

    @Override
    public Curso buscarPorId(Long id) { // Verificação básica — não dá pra buscar algo sem ID.

        if (id == null) {
            throw new RuntimeException("ID não pode ser nulo!");
        }

        return cursoDao.buscarPorId(id);
    }
    
    @Override
    public Curso buscarPorNome(String nome) { // busca curso pelo nome.

        if (StringUtil.isNullOrEmpty(nome)) {
            throw new RuntimeException("Nome não pode ser vazio!"); // Mesma coisa aqui: nome não pode ser vazio.
        }

        return cursoDao.buscarPorNome(nome); // Chama o DAO pra procurar um curso com esse nome.
    }
    
    
}

