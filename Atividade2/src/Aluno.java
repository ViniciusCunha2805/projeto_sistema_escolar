public class Aluno extends Pessoa {

    private String matricula;

    public Aluno(String nome, String cpf, String m) {
        super(nome, cpf);
        this.matricula = m;
    }

    public String toString() {
        return nome + " (MATRICULA: " + this.matricula + ")";
    }

    public String getMatricula() {
        return this.matricula;
    }

}
