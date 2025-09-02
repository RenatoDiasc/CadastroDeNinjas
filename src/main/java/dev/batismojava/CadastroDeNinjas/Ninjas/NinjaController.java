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
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja){
        return ninjaService.criarNinja(ninja);
    }

    //listar todos ninjas
    @GetMapping("/listar")
    public List<NinjaDTO> listarNinjas(){

        return ninjaService.listarNinjas();
}

    //listar ninja por Id
    @GetMapping("/listar/{id}")
    public NinjaDTO listarNinjasPorId(@PathVariable long id){
        return ninjaService.listarNinjasPorId(id);
    }

    //alterar dados do ninja (update)
    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarNinjaPorId(@PathVariable long id,@RequestBody NinjaDTO NinjaDTO) {
        return ninjaService.alterar(id,NinjaDTO);
    }

    //deletar ninja  (delete)
    @DeleteMapping("/deletarID/{id}")
        public void deletarNinja(@PathVariable long id){
            ninjaService.deletarNinja(id);
        }
    }
