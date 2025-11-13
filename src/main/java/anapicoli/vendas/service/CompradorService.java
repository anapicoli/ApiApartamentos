package anapicoli.vendas.service;

import anapicoli.vendas.model.Comprador;
import anapicoli.vendas.repository.CompradorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CompradorService {

    private final CompradorRepository repository;

    public CompradorService(CompradorRepository repository) {
        this.repository = repository;
    }

    public Comprador salvar(Comprador comprador) {
        if (!comprador.getCidade().equalsIgnoreCase("São Paulo")) {
            throw new RuntimeException("Somente compradores da cidade de São Paulo são permitidos");
        }
        return repository.save(comprador);
    }

    public List<Comprador> listar() {
        return repository.findAll();
    }

    public Comprador buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comprador não encontrado"));
    }

    public Comprador atualizar(Long id, Comprador atualizado) {
        Comprador existente = buscarPorId(id);
        existente.setNome(atualizado.getNome());
        existente.setCpfCnpj(atualizado.getCpfCnpj());
        existente.setTelefone(atualizado.getTelefone());
        existente.setEmail(atualizado.getEmail());
        existente.setCidade(atualizado.getCidade());
        return repository.save(existente);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}