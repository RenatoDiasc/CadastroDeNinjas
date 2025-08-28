package dev.batismojava.CadastroDeNinjas.Ninjas;

import dev.batismojava.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// transforma classe em entidade no BD
@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    @Column(unique=true)
    private String email;

    private int idade;

    //@ManyToOne Um ninja tem uma única missão
    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;

}