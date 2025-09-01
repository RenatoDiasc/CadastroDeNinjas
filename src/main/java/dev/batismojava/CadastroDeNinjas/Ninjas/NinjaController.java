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
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return ninjaService.criarNinja(ninja);
    }

    //listar todos ninjas
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
    return ninjaService.listarNinjas();
}

    //listar ninja por Id
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasPorId(@PathVariable long id){
        return ninjaService.listarNinjasPorId(id);
    }

    //alterar dados do ninja (update)
    @PutMapping("/alterar/{id}")
    public NinjaModel alterarNinjaPorId(@PathVariable long id,@RequestBody NinjaModel ninjaModel) {
        return ninjaService.alterar(id,ninjaModel);
    }

    //deletar ninja  (delete)
    @DeleteMapping("/deletarID/{id}")
        public void deletarNinja(@PathVariable long id){
            ninjaService.deletarNinja(id);
        }
    }
