package dev.batismojava.CadastroDeNinjas.Missoes;

import dev.batismojava.CadastroDeNinjas.Ninjas.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> listarMissoes(){
        List<MissoesDTO> missoes = missoesService.listarMissoes();

        if(missoes != null){
            return ResponseEntity.ok(missoes);
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não há missoes registradas");
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable long id){
        MissoesDTO missao = missoesService.listarMissaoPorId(id);
        if(missao != null){
            return ResponseEntity.ok(missao);
        }else
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missão buscado não existe nos registros");
    }

    //Post-- requisição para criar missao
    @PostMapping("/criar")
    public ResponseEntity criarMissao(@RequestBody MissoesDTO missao){
        missoesService.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("A missão " + missao.getNome() + " foi cadastrada com sucesso");
    }

    //Put -- requisição para editar missoes
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMissao(@PathVariable long id, @RequestBody MissoesDTO missoesModel){

        MissoesDTO missaoDTO  = missoesService.alterarMissao(id,missoesModel);
        if(missaoDTO != null){
            return ResponseEntity.ok(missaoDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missão buscado não existe nos registros");
        }
    }

    //delete - deletar missoes
    @DeleteMapping("/deletarID/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable long id){

        if(missoesService.listarMissaoPorId(id) != null){
            missoesService.deletarMissao(id);
            return ResponseEntity.ok("A Missão de id " + id + " foi deletada com sucesso!");
        }else
             return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Esta missão não existe nos registros.");

    }
}
