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

    public DisciplinaController() {
        this.disciplinas = new ArrayList<>();
        disciplinas.add(new Disciplina(1, "Programação de Sistemas II", "ENEC600012", "Sistemas de Informação", 3));
        disciplinas.add(new Disciplina(2, "Estrutura de Dados", "ENEC609281", "Sistemas de Informação", 3));
        disciplinas.add(new Disciplina(3, "Web Mobile", "ENEC600175", "Sistemas de Informação", 2));
    }

    // retorna as disciplinas
    @GetMapping("api/disciplinas")
    Iterable<Disciplina> getDisciplinas() {
        return this.disciplinas;
    }

    // retorna uma disciplina específica
    @GetMapping("api/disciplinas/{id}")
    Optional<Disciplina> getDisciplina(@PathVariable long id) {
        for (Disciplina d : disciplinas) {
            if (d.getId() == id) {
                return Optional.of(d);
            }
        }
        return Optional.empty();
    }

    // cria uma nova disciplina
    @PostMapping("api/disciplinas")
    Disciplina createDisciplina(@RequestBody Disciplina d) {
        long maxId = 1;
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getId() > maxId) {
                maxId = disciplina.getId();
            }
        }
        d.setId(maxId + 1);
        disciplinas.add(d);
        return d;
    }

    // apaga uma disciplina
    @DeleteMapping("api/disciplinas/{id}")
    void deleteDisciplina(@PathVariable int id) {
        disciplinas.removeIf(d -> d.getId() == id);
    }

    //atualiza uma disciplina inteira
    @PutMapping("api/disciplinas/{id}")
    Optional<Disciplina> updateDisciplina(@RequestBody Disciplina disciplinaRequest, @PathVariable long disciplinaId) {
        Optional<Disciplina> opt = this.getDisciplina(disciplinaId);
        if (opt.isPresent()) {
            Disciplina disciplina = opt.get();
            disciplina.setNome(disciplinaRequest.getNome());
            disciplina.setSigla(disciplinaRequest.getSigla());
            disciplina.setCurso(disciplinaRequest.getCurso());
            disciplina.setSemestre(disciplinaRequest.getSemestre());
        }
        return opt;
    }

    

}