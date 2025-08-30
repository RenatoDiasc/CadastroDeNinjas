package dev.batismojava.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {

    private NinjaRepository NinjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        NinjaRepository = ninjaRepository;
    }

    //Listar todos os ninjas
    public List<NinjaModel> listarNinjas() {
        return NinjaRepository.findAll();
    }

}
