package anapicoli.vendas.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Apartamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private String endereco;
    private int quartos;
    private double area;
    private double preco;
    private String status;
}