package dev.batismojava.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.lang.reflect.Field;
import org.springframework.util.ReflectionUtils;




@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Listar todos os ninjas
    public List<NinjaDTO> listarNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    //Listar ninja por ID
    public NinjaDTO listarNinjasPorId(long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.map(ninjaMapper::map).orElse(null);
    }

    //Criar novo ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    //Deletar Ninja
    public void deletarNinja(long id) {
        ninjaRepository.deleteById(id);
    }

    //Alterar Tudo Ninja
    public NinjaDTO alterar(long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if (ninjaExistente.isPresent()) {
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }

    public NinjaDTO alterarParcial(long id, Map<String, Object> campos) {
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);

        if (ninjaExistente.isPresent()) {
            NinjaModel ninja = ninjaExistente.get();

            campos.forEach((chave, valor) -> {
                Field campo = ReflectionUtils.findField(NinjaModel.class, chave);
                if (campo != null) {
                    campo.setAccessible(true);
                    ReflectionUtils.setField(campo, ninja, valor);
                }
            });

            NinjaModel ninjaSalvo = ninjaRepository.save(ninja);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }


}
