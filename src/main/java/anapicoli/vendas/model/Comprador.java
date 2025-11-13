package anapicoli.vendas.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Comprador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpfCnpj;
    private String telefone;
    private String email;
    private String cidade;
}