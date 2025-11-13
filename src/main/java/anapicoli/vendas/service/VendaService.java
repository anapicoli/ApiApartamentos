package anapicoli.vendas.service;

import anapicoli.vendas.model.Apartamento;
import anapicoli.vendas.model.Comprador;
import anapicoli.vendas.model.Venda;
import anapicoli.vendas.repository.ApartamentoRepository;
import anapicoli.vendas.repository.CompradorRepository;
import anapicoli.vendas.repository.VendaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VendaService {

    private final ApartamentoRepository apartamentoRepository;
    private final CompradorRepository compradorRepository;
    private final VendaRepository vendaRepository;

    public VendaService(ApartamentoRepository apartamentoRepository,
                        CompradorRepository compradorRepository,
                        VendaRepository vendaRepository) {
        this.apartamentoRepository = apartamentoRepository;
        this.compradorRepository = compradorRepository;
        this.vendaRepository = vendaRepository;
    }

    public Venda registrarVenda(Long apartamentoId, Long compradorId) {
        Apartamento apt = apartamentoRepository.findById(apartamentoId)
                .orElseThrow(() -> new RuntimeException("Apartamento não encontrado"));

        Comprador comprador = compradorRepository.findById(compradorId)
                .orElseThrow(() -> new RuntimeException("Comprador não encontrado"));

        if (!comprador.getCidade().equalsIgnoreCase("São Paulo")) {
            throw new RuntimeException("Somente compradores da cidade de São Paulo são permitidos");
        }

        if (apt.getStatus().equalsIgnoreCase("indisponivel")) {
            throw new RuntimeException("Apartamento já foi vendido");
        }

        apt.setStatus("indisponivel");
        apartamentoRepository.save(apt);

        Venda venda = new Venda();
        venda.setApartamento(apt);
        venda.setComprador(comprador);
        venda.setDataVenda(LocalDate.now());

        return vendaRepository.save(venda);
    }

    public List<Venda> listarVendas() {
        return vendaRepository.findAll();
    }
}