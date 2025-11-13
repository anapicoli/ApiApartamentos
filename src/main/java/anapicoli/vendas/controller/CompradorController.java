package anapicoli.vendas.controller;

import anapicoli.vendas.model.Comprador;
import anapicoli.vendas.service.CompradorService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/compradores")
public class CompradorController {

    private final CompradorService service;

    public CompradorController(CompradorService service) {
        this.service = service;
    }

    @PostMapping
    public Comprador salvar(@RequestBody Comprador comprador) {
        return service.salvar(comprador);
    }

    @GetMapping
    public List<Comprador> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Comprador buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Comprador atualizar(@PathVariable Long id, @RequestBody Comprador atualizado) {
        return service.atualizar(id, atualizado);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}