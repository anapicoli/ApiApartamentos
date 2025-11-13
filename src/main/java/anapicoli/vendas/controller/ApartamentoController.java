package anapicoli.vendas.controller;

import anapicoli.vendas.model.Apartamento;
import anapicoli.vendas.service.ApartamentoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/apartamentos")
public class ApartamentoController {

    private final ApartamentoService service;

    public ApartamentoController(ApartamentoService service) {
        this.service = service;
    }

    @PostMapping
    public Apartamento salvar(@RequestBody Apartamento apartamento) {
        return service.salvar(apartamento);
    }

    @GetMapping
    public List<Apartamento> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Apartamento buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Apartamento atualizar(@PathVariable Long id, @RequestBody Apartamento atualizado) {
        return service.atualizar(id, atualizado);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}