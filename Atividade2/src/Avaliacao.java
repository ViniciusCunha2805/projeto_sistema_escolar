public class Avaliacao {

    private String nome;
    private Data dataAplicacao;
    private int valor;

    public Avaliacao(String n, Data d, int v) {
        this.nome = n;
        this.dataAplicacao = d;
        this.valor = v;
    }

    public double nota(String cpf) {
        return 0.0;
    }

    public double notaFinal(String cpf) {return 0.0;}

    public String imprimeSequenciaNotas(Aluno a) { return "";}

    public String notasToString() { return "";}

}
