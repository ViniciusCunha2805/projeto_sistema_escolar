import java.util.ArrayList;

public class GrupoTrabalho {

    private ArrayList<Aluno> alunos;
    private double notaFinal;

    public GrupoTrabalho(double nf) {
        this.notaFinal = nf;
        alunos = new ArrayList<>();
    }

    public void addAlunosGrupo(Aluno a) {
        this.alunos.add(a);
    }


    // Retorna se achou o aluno.
    public boolean alunoNoGrupo(String cpf) {
        for (Aluno a : this.alunos) {
            if (a.cpf.equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    public double getNotaFinal(String c) {
        return this.notaFinal;
    }

    public void printGruposNotas() {
        for(Aluno a : this.alunos) {
            System.out.println(a.nome + "-" + a.cpf + this.notaFinal);
        }
    }


}
