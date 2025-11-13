package anapicoli.vendas.controller;

import anapicoli.vendas.model.Venda;
import anapicoli.vendas.service.VendaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    private final VendaService vendaService;

    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @PostMapping("/{apartamentoId}/{compradorId}")
    public Venda registrar(@PathVariable Long apartamentoId, @PathVariable Long compradorId) {
        return vendaService.registrarVenda(apartamentoId, compradorId);
    }

    @GetMapping
    public List<Venda> listar() {
        return vendaService.listarVendas();
    }
}