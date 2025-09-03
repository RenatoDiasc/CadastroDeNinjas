package dev.batismojava.CadastroDeNinjas.Missoes;

import dev.batismojava.CadastroDeNinjas.Ninjas.NinjaDTO;
import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {


    public MissoesModel map(MissoesDTO missoesDTO){

        MissoesModel missoesModel = new MissoesModel();

        //mapeando de uma entidade para uma DTO
        missoesModel.setId(missoesDTO.getId());
        missoesModel.setNome(missoesDTO.getNome());
        missoesModel.setRank(missoesDTO.getRank());
        missoesModel.setNinjas(missoesDTO.getNinjas());

        return missoesModel;
    }

    public MissoesDTO map(MissoesModel missoesModel){

        MissoesDTO missoesDTO = new MissoesDTO();

        //mapeando de uma DTO para uma entidade
        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setNome(missoesModel.getNome());
        missoesDTO.setRank(missoesModel.getRank());
        missoesDTO.setNinjas(missoesModel.getNinjas());

        return missoesDTO;
    }
}
