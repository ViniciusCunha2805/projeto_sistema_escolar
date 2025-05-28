import java.util.ArrayList;

public class AlunoProva {

    private Aluno aluno;
    private ArrayList<Double> notasPerQuestao;

    public AlunoProva(Aluno a) {
        this.aluno = a;
        this.notasPerQuestao = new ArrayList<>();
    }

    public void addNotas(double nota) {
        this.notasPerQuestao.add(nota);
    }

    public String getCpf() {
        return this.aluno.cpf;
    }

    public double notaTotal() {
        double total = 0.0;
        for (double nota : this.notasPerQuestao) {
            total += nota;
        }
        return total;
    }
}
