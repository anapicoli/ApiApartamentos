package anapicoli.vendas.repository;

import anapicoli.vendas.model.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompradorRepository extends JpaRepository<Comprador, Long> {
}
