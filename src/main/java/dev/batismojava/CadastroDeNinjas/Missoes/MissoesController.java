package dev.batismojava.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    //Get -- mandar requisição para mostrar missoes
    @GetMapping("/listar")
    public String listarMissao(){
        return "Missoes listadas";
    }

    //Post-- requisição para criar missao
    @PostMapping("/criar")
    public String criarMissao(){
        return "Missao criada";
    }

    //Put -- requisição para editar missoes
    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missao alterada";
    }

    //delete - deletar missoes
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missao deletada";
    }
}
