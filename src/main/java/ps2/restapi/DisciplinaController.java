package ps2.restapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class DisciplinaController {
    private List<Disciplina> disciplinas;

    public DisciplinaController(){
        this.disciplinas = new ArrayList<>();
        disciplinas.add(new Disciplina(1,"Programação de Sistemas II","ENEC600012","Sistemas de Informação",3));
        disciplinas.add(new Disciplina(2,"Estrutura de Dados","ENEC609281","Sistemas de Informação",3));
        disciplinas.add(new Disciplina(3,"Web Mobile","ENEC600175","Sistemas de Informação",2));
    }

    @GetMapping("api/disciplinas")
    Iterable<Disciplina> getDisciplinas(){
        return this.disciplinas;
    }

    @DeleteMapping("api/disciplinas/{id}")
    void deleteDisciplina(@PathVariable int id){
        disciplinas.removeIf(d -> d.getId() == id);
    }

    @PostMapping("api/disciplinas")
    void createDisciplina(@RequestBody Disciplina d){

    }

}