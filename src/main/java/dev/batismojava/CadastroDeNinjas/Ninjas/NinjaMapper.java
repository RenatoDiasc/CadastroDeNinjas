package dev.batismojava.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaModel map(NinjaDTO ninjaDTO){

        NinjaModel ninjaModel = new NinjaModel();

        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setIdade(ninjaDTO.getIdade());
        ninjaModel.setNome(ninjaDTO.getNome());
        ninjaModel.setImgUrl(ninjaDTO.getImgUrl());
        ninjaModel.setTelefone(ninjaDTO.getTelefone());
        ninjaModel.setMissoes(ninjaDTO.getMissoes());

        return ninjaModel;
    }
    public NinjaDTO map(NinjaModel ninjaModel){

        NinjaDTO ninjaDTO = new NinjaDTO();

        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setIdade(ninjaModel.getIdade());
        ninjaDTO.setNome(ninjaModel.getNome());
        ninjaDTO.setImgUrl(ninjaModel.getImgUrl());
        ninjaDTO.setTelefone(ninjaModel.getTelefone());
        ninjaDTO.setMissoes(ninjaModel.getMissoes());

        return ninjaDTO;
    }
}
