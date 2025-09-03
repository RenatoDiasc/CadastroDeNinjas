package dev.batismojava.CadastroDeNinjas.Missoes;

import dev.batismojava.CadastroDeNinjas.Ninjas.NinjaMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    //listar todas missões
    public List<MissoesDTO> listarMissoes(){
        List<MissoesModel> missoes = missoesRepository.findAll();

        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());

    }

    //listar missao por id
    public MissoesDTO listarMissaoPorId(long id){
        Optional<MissoesModel> missaoPorId= missoesRepository.findById(id);
        return missaoPorId.map(missoesMapper::map).orElse(null);
    }
    //criar missao
    public MissoesDTO criarMissao(MissoesDTO missaoDTO){
        MissoesModel missao = missoesMapper.map(missaoDTO);
        missao = missoesRepository.save(missao);
        return missoesMapper.map(missao);
    }

    //deletar missao

    public void deletarMissao(long id){
        missoesRepository.deleteById(id);
    }

    //atualizar missao
    public MissoesDTO alterarMissao(long id, MissoesDTO missaoDTO){

        Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);

        if(missaoExistente.isPresent()){
            MissoesModel missaoAtualizada = missoesMapper.map(missaoDTO);
            missaoAtualizada.setId(id);
            MissoesModel missaoSalva = missoesRepository.save(missaoAtualizada);
            return missoesMapper.map(missaoSalva);
        }
        return null;
    }
}
