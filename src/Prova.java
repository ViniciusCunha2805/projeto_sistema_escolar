import java.util.ArrayList;

public class Prova extends Avaliacao {

    private int qtdQuestoes;
    private ArrayList<AlunoProva> alunosProva;

    public Prova(String n, Data d, double v, int qtd) {
        super(n, d, v);
        this.qtdQuestoes = qtd;
        this.alunosProva = new ArrayList<>();
    }

    public void addAlunoProva(AlunoProva aNota) {
        this.alunosProva.add(aNota);
    }

    public double nota(String cpf) {
        for (AlunoProva ap : this.alunosProva) {
            if (ap.getCpf().equals(cpf)) {
                return ap.notaTotal();
            }
        }
        return 0;
    }

}
