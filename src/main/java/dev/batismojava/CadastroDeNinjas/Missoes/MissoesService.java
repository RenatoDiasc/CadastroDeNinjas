package dev.batismojava.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    //listar todas missões
    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    //listar missao por id

    public MissoesModel listarMissaoPorId(long id){
        Optional<MissoesModel> missaoPorId= missoesRepository.findById(id);
        return missaoPorId.orElse(null);
    }
    //criar missao
    public MissoesModel criarMissao(MissoesModel missao){
        return missoesRepository.save(missao);
    }

    //deletar missao

    public void deletarMissao(long id){
        missoesRepository.deleteById(id);
    }

    //atualizar missao
    public MissoesModel alterarMissao(long id, MissoesModel missoesModel){
        if(missoesRepository.existsById(id)){
            missoesModel.setId(id);
            return missoesRepository.save(missoesModel);
        }
        return null;
    }
}
