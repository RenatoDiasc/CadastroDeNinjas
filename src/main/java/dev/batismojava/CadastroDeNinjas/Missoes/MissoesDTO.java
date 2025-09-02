package dev.batismojava.CadastroDeNinjas.Missoes;

import dev.batismojava.CadastroDeNinjas.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissoesDTO {

    private Long id;
    private String nome;
    private String rank;
    private List<NinjaModel> ninjas;
}
