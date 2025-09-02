package dev.batismojava.CadastroDeNinjas.Ninjas;

import dev.batismojava.CadastroDeNinjas.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaDTO {

        private long id;
        private String nome;
        private String email;
        private String imgUrl;
        private int idade;
        private MissoesModel missoes;
        private String telefone;
}
