package br.com.ifba.curso.service;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.repository.CursoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;


// são feitas as validações, regras de negócio.
@Service
public class CursoService implements CursoIService {

    private final CursoRepository repository; // reduz o acoplamento, deixando mais organizado.

    public CursoService(CursoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Curso salvar(Curso curso) {
        
        // verifica se o nome é nulo ou vazio.
        if (curso.getNome() == null || curso.getNome().isBlank()) {
            throw new RuntimeException("Nome inválido!");
        }

        // verifica se o codigo é nulo ou vazio.
        if (curso.getCodigo() == null || curso.getCodigo().isBlank()) {
            throw new RuntimeException("Código inválido!");
        }

        // Nome repetido
        if (repository.buscarPorNome(curso.getNome()).isPresent()) {
            throw new RuntimeException("Já existe um curso com esse nome!");
        }

        // Código repetido
        if (repository.buscarPorCodigo(curso.getCodigo()).isPresent()) {
            throw new RuntimeException("Já existe um curso com esse código!");
        }

        return repository.save(curso); // Se tudo isso tiver certo, salva o curso.
    }

    @Override
    public Curso atualizar(Curso curso) {

        if (curso.getId() == null) {
            throw new RuntimeException("ID não pode ser nulo!");
        }

        // Nome repetido
        Optional<Curso> existenteNome = repository.buscarPorNome(curso.getNome());
        if (existenteNome.isPresent() && !existenteNome.get().getId().equals(curso.getId())) {
            throw new RuntimeException("Outro curso já usa esse nome!");
        }

        // Código repetido
        Optional<Curso> existenteCodigo = repository.buscarPorCodigo(curso.getCodigo());
        if (existenteCodigo.isPresent() && !existenteCodigo.get().getId().equals(curso.getId())) {
            throw new RuntimeException("Outro curso já usa esse código!");
        }

        return repository.save(curso);
    }

    @Override
    public void deletar(Curso curso) {
        repository.delete(curso);
    }

    @Override
    public List<Curso> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Curso buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado!"));
    }

    @Override
    public Curso buscarPorNome(String nome) {
        return repository.buscarPorNome(nome)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado!"));
    }

    @Override
    public Curso buscarPorCodigo(String codigo) {
        return repository.buscarPorCodigo(codigo)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado!"));
    }
}
