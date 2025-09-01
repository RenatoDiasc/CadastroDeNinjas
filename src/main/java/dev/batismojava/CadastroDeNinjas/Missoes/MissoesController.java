package dev.batismojava.CadastroDeNinjas.Missoes;

import dev.batismojava.CadastroDeNinjas.Ninjas.NinjaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    //Get -- mandar requisição para mostrar missoes
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes(){
        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissoesModel listarPorId(@PathVariable long id){
        return missoesService.listarMissaoPorId(id);
    }

    //Post-- requisição para criar missao
    @PostMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missao){
        return missoesService.criarMissao(missao);
    }

    //Put -- requisição para editar missoes
    @PutMapping("/alterar/{id}")
    public MissoesModel alterarMissao(@PathVariable long id, @RequestBody MissoesModel missoesModel){
        return missoesService.alterarMissao(id, missoesModel);
    }

    //delete - deletar missoes
    @DeleteMapping("/deletarID/{id}")
    public void deletarMissao(@PathVariable long id){
        missoesService.deletarMissao(id);
    }
}
