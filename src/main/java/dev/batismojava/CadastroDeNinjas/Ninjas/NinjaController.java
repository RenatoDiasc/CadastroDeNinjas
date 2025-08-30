package dev.batismojava.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    //adicionar ninja  (create)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja criado";
    }
    //mostrar todos ninjas  (read)
    @GetMapping("/all")
    public String mostrarTodosOsNinjas(){
        return "Mostrar Ninja";
    }
    //procurar ninja por ID (create)
    @GetMapping("/todosID")
    public String mostrarTodosOsNinjasId(){
    return "Mostrar ninja por ID";
}

    //alterar dados do ninja (update)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId() {
        return "Alterar ninja por ID";
        //deletar ninja  (delete)
    }
        @DeleteMapping("/deletarID")
        public String deletarNinjaPorId(){
            return "Ninja deletado por Id";
        }
    }
