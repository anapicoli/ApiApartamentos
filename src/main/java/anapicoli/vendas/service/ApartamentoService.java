package anapicoli.vendas.service;

import anapicoli.vendas.model.Apartamento;
import anapicoli.vendas.repository.ApartamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartamentoService {

    private final ApartamentoRepository repository;

    public ApartamentoService(ApartamentoRepository repository) {
        this.repository = repository;
    }

    // Cadastrar apartamento
    public Apartamento salvar(Apartamento apartamento) {
        apartamento.setStatus("disponivel");
        return repository.save(apartamento);
    }

    // Listar todos os apartamentos
    public List<Apartamento> listar() {
        return repository.findAll();
    }

    // Buscar por ID
    public Apartamento buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Apartamento não encontrado"));
    }

    // Atualizar apartamento
    public Apartamento atualizar(Long id, Apartamento atualizado) {
        Apartamento existente = buscarPorId(id);
        existente.setCodigo(atualizado.getCodigo());
        existente.setEndereco(atualizado.getEndereco());
        existente.setQuartos(atualizado.getQuartos());
        existente.setArea(atualizado.getArea());
        existente.setPreco(atualizado.getPreco());
        existente.setStatus(atualizado.getStatus());
        return repository.save(existente);
    }

    // Excluir apartamento
    public void excluir(Long id) {
        repository.deleteById(id);
    }
}