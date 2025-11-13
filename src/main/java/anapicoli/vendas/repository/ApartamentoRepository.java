package anapicoli.vendas.repository;

import anapicoli.vendas.model.Apartamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartamentoRepository extends JpaRepository<Apartamento, Long> {
}