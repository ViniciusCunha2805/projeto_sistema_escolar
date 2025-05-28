import java.util.ArrayList;

public class Turma {

    private String nome;
    private int anoTurma;
    private int semestre;
    private Professor profResp;
    private Aluno[] alunosMatriculados;
    private Avaliacao[] avaliacoes;

    public Turma(String n, int at, int sem, Professor p) {
        this.nome = n;
        this.anoTurma = at;
        this.semestre = sem;
        this.profResp = p;
    }

    public void setListAvaliacao(Avaliacao[] avs) {
        this.avaliacoes = avs;
    }

    public void setListAlunos(Aluno[] alunos) {
        this.alunosMatriculados = alunos;
    }

    public void medias() {
        imprimirNotasTurma();
    }

    public void imprimirNotasTurma() {
        double mediaTurma = 0.0;
        System.out.println("Médias da Turma: " + this.nome + "(" + this.anoTurma + "/" + this.semestre + "): ");

        for (Aluno a : this.alunosMatriculados) {
            String notasAvs = "";
            double notaFinal = 0;
            for(Avaliacao ava : this.avaliacoes) {
                double notaAva = ava.nota(a.cpf);
                notasAvs += notaAva + " ";
                notaFinal += notaAva;
            }
            if (notaFinal > 100) {
                notaFinal = 100;
            }
            System.out.println(a.toString() + ": " + notasAvs + "= " + notaFinal);
            mediaTurma += notaFinal;
        }

        System.out.println("Media da turma: " + (mediaTurma / this.alunosMatriculados.length) + "\n");
    }
}
