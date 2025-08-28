package dev.batismojava.CadastroDeNinjas.Missoes;

import dev.batismojava.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Tb_missoes)")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String rank;

    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;

}


