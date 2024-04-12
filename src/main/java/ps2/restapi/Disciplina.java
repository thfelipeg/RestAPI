package ps2.restapi;

public class Disciplina {
    private int id;
    private String nome;
    private String sigla;
    private String curso;
    private int semestre;

    public Disciplina(int id, String nome, String sigla, String curso, int semestre){
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.curso = curso;
        this.semestre = semestre;
    }

    //getters

    public int getId(){
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }

    public String getSigla(){
        return this.sigla;
    }

    public String getCurso(){
        return this.curso;
    }

    public int getSemestre(){
        return this.semestre;
    }

    //setters

    public void setId(int i){
        this.id = i;
    }

    public void setNome(String n){
        this.nome = n;
    }

    public void setSigla(String s){
        this.sigla = s;
    }

    public void setCurso(String c){
        this.curso = c;
    }

    public void setSemestre(int s){
        this.semestre = s;
    }
}
