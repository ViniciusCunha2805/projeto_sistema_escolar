public class Avaliacao {

    protected String nome;
    protected Data dataAplicacao;
    protected double valor;

    public Avaliacao(String n, Data d, double v) {
        this.nome = n;
        this.dataAplicacao = d;
        this.valor = v;
    }

    public double nota(String cpf) {
        return 0.0;
    }

}
