package anapicoli.vendas.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Apartamento apartamento;

    @ManyToOne
    private Comprador comprador;

    private LocalDate dataVenda;
}