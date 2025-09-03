package dev.batismojava.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @Operation(summary = "Mensagem de boas vindas", description = "Essa rota da uma mensagem de boas vidas para quem acessar ela")
    public String boasVindas(){

        return "Essa é minha primeira mensagem nessa rota";
    }

    //adicionar ninja  (create)
    @PostMapping("/criar")
    @Operation(summary ="Cria um novo ninja",description = "Essa rota cria um novo ninja e o insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do Ninja")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){

        NinjaDTO ninjaDTO =  ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " +ninjaDTO.getNome() + " id: " + ninjaDTO.getId());
    }

    //listar todos ninjas
    @GetMapping("/listar")
    @Operation(summary ="Lista todos os ninjas do banco de dados",description = "Essa rota imprime para o usuario, todos os ninjas que foram cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninjas listados com sucesso"),
    })
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
    List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
}

    //listar ninja por Id
    @GetMapping("/listar/{id}")
    @Operation(summary ="Lista um ninja especifico por Id",description = "Essa rota busca e imprime o ninja com o ID inserido, caso esteja no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "404", description = "O ninja com id inserido não está presente no banco de dados")
    })
    public ResponseEntity<?> listarNinjasPorId(@PathVariable long id) {

        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O id buscado não existe nos registros");
        }
    }


    //alterar dados do ninja (update)
    @PutMapping("/alterar/{id}")
    @Operation(summary ="Altera informações de um ninja",description = "Essa rota permite alterar informação de um ninja e atualiza no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "O ninja com o id especificado não existe no banco de dados")
    })
    public ResponseEntity<?> alterarNinjaPorId(
            @Parameter(description = "Usuario insere o id do ninja que deseja alterar")
            @PathVariable long id,
            @Parameter(description = "Usuario insere a informação que deseja alterar no corpo da requisição")
            @RequestBody NinjaDTO NinjaDTO) {
        NinjaDTO ninja =  ninjaService.alterar(id,NinjaDTO);

        if(ninja != null){
            return ResponseEntity.ok(ninja);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O id buscado não existe nos registros");
        }
    }

    //deletar ninja  (delete)
    @DeleteMapping("/deletarID/{id}")
    @Operation(summary ="Apaga o ninja especificado no banco de dados",description = "Essa rota deleta um ninja ")
    @Parameter(description = "Usuario insere o ID do ninja que deseja deletar")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja deletado com sucesso"),
    })
        public ResponseEntity<String> deletarNinja(@PathVariable long id){
        if(ninjaService.listarNinjasPorId(id) != null) {
            ninjaService.deletarNinja(id);
            return ResponseEntity.ok("Ninja com id: " + id + " deletado com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com id: " + id + " não encontrado");
        }
        }
    }
