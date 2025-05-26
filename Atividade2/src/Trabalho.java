import java.util.ArrayList;

public class Trabalho extends Avaliacao {

    private int maxIntegrantes;
    private ArrayList<GrupoTrabalho> grupoTrabalho;

    public Trabalho(String n, Data d, int v, int max) {
        super(n, d, v);
        this.maxIntegrantes = max;
        this.grupoTrabalho = new ArrayList<>();
    }

    public void addGrupoTrabalho(GrupoTrabalho gp) {
        this.grupoTrabalho.add(gp);
    }

    public void listarGrupos() {
        for (GrupoTrabalho gt : this.grupoTrabalho) {
            gt.printGruposNotas();
        }
    }

    public double nota(String cpf) {
        for (GrupoTrabalho gt : this.grupoTrabalho) {
            if (gt.alunoNoGrupo(cpf)) {
                return gt.getNotaFinal(cpf);
            }
        }
        return 0.0;
    }
}
