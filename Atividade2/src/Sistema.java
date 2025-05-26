import java.util.ArrayList;

public class Sistema {

    private ArrayList<Aluno> alunos;
    private ArrayList <Professor> professores;
    private ArrayList <Turma> turmas;

    public Sistema() {
            this.alunos = new ArrayList<>();
            this.professores = new ArrayList<>();
            this.turmas = new ArrayList<>();
    }


    public void listarProfs() {
        if (this.professores.size() > 0) {
            System.out.println("Professores cadastrados:");
            for (Professor p : this.professores) {
                System.out.println("* " + p);
            }
        }
        else {
            System.out.println("Nenhum professor cadastrado até o momento.");
        }
    }

    public void listarAlunos() {
        if (this.alunos.size() > 0) {
            System.out.println("Alunos cadastrados: ");
            for (Aluno a : this.alunos) {
                System.out.println("* " + a);
            }
        } else {
            System.out.println("Não há alunos cadastrados.");
        }
    }

    public void listarTurmas() {
        if (this.turmas.size() > 0) {
            System.out.println("Turmas cadastradas: ");
            for (Turma t : this.turmas) {
               t.medias();
            }
        } else {
            System.out.println("Não há turmas cadastrados.");
        }
    }

    public Pessoa encontrarPessoaCpf(String cpf) {
        for (Professor p : this.professores) {
            if (p.getCpf().equals(cpf)) {
                return p;
            }
        }

        for (Aluno a : this.alunos) {
            if (a.getCpf().equals(cpf)) {
                return a;
            }
        }
        return null;
    }

    public Aluno encontrarAluno(String matricula) {
        for (Aluno a : this.alunos) {
            if (a.getMatricula().equals(matricula)) {
                return a;
            }
        }
        return null;
    }

    public void novoProfessor(Professor p) {
        this.professores.add(p);
    }

    public void novoAluno(Aluno a) {
        this.alunos.add(a);
    }

    public void novaTurma(Turma t) {
        this.turmas.add(t);
    }

}
