package dev.batismojava.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas(){

        return "Essa é minha primeira mensagem nessa rota";
    }

    //adicionar ninja  (create)
    @PostMapping("/criar")
    public String criarNinja(){

        return "Ninja criado";
    }

    //listar todos ninjas
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
    return ninjaService.listarNinjas();
}

    //alterar dados do ninja (update)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId() {
        return "Alterar ninja por ID";
    }

    //deletar ninja  (delete)
    @DeleteMapping("/deletarID")
        public String deletarNinjaPorId(){
            return "Ninja deletado por Id";
        }
    }
