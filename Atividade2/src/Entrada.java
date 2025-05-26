import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe com as rotinas de entrada e saída do projeto
 * @author Hilario Seibel Junior e <Matheus Magnago e Vinicius Cunha>
 */
public class Entrada {
    public Scanner input;

    public Entrada() {
        try {
            // Se houver um arquivo input.txt, o Scanner vai ler dele.
            this.input = new Scanner(new FileInputStream("Atividade2/input.txt"));
        } catch (FileNotFoundException e) {
            // Caso contrário, vai ler do teclado.
            this.input = new Scanner(System.in);
        }
    }

    private String lerLinha(String msg) {
        // Imprime uma mensagem ao usuário, lê uma e retorna esta linha
        System.out.println(msg);
        String linha = this.input.nextLine();

        // Ignora linhas começando com #, que vão indicar comentários no arquivo de entrada:
        while (linha.charAt(0) == '#') linha = this.input.nextLine();
        return linha;
    }


    private int lerInteiro(String msg) {
        // Imprime uma mensagem ao usuário, lê uma linha contendo um inteiro e retorna este inteiro
        String linha = this.lerLinha(msg);
        return Integer.parseInt(linha);
    }

    private double lerDouble(String msg) {
        // Imprime uma mensagem ao usuário, lê uma linha contendo um double e retorna este double
        String linha = this.lerLinha(msg);
        return Double.parseDouble(linha);
    }

    public int menu() {
        // Imprime o menu principal, lê a opção escolhida pelo usuário e retorna a opção selecionada.

        String msg = "\n*********************\n" +
                "Escolha uma opção:\n" +
                "1) Cadastrar professor:\n" +
                "2) Cadastrar aluno:\n" +
                "3) Cadastrar turma:\n" +
                "4) Listar turmas:\n" +
                "0) Sair\n" +
                "*********************\n";

        int op = this.lerInteiro(msg);

        while (op < 0 || op > 4) {
            System.out.println("Opção inválida. Tente novamente: ");
            op = this.lerInteiro(msg);
        }
        return op;
    }

    public void cadastrarProfessor(Sistema s) {
        s.listarProfs();

        String nome = this.lerLinha("Digite o nome do professor: ");
        String cpf = this.lerLinha("Digite o cpf do professor: ");
        double salario = this.lerDouble("Digite o salário do professor: R$");

        if (s.encontrarPessoaCpf(cpf) == null) { // Garantindo que o CPF não esteja duplicado.
            Professor p = new Professor(nome, cpf, salario);
            s.novoProfessor(p);
        }
        else {
            System.out.println("Erro: CPF duplicado. Professor não adicionado.");
        }
        s.listarProfs();
    }

    public void cadastrarAluno(Sistema s) {
        s.listarAlunos();

        String nome = this.lerLinha("Digite o nome do aluno: ");
        String cpf = this.lerLinha("Digite o cpf do aluno: ");

        if (s.encontrarPessoaCpf(cpf) == null) {
            String matricula = this.lerLinha("Digite a matrícula do aluno: ");
            if (s.encontrarAluno(matricula) == null) { // Garantindo que a matrícula não esteja duplicada.
                Aluno a = new Aluno(nome, cpf, matricula);
                s.novoAluno(a);
            }
        } else {
            System.out.println("Erro: CPF duplicado. Aluno não adicionado.");
        }

        s.listarAlunos();
    }

    public void cadastrarTurma(Sistema s) {
        s.listarTurmas();

        String nome = lerLinha("Digite o nome da turma: ");
        int ano = lerInteiro("Digite o ano inicial da turma: ");
        int sem = lerInteiro("Digite em qual semestre a turma se encontra: ");
        String cpf = lerLinha("Digite o CPF do professor responsável: ");
        Professor p = (Professor) s.encontrarPessoaCpf(cpf);

        if (s.encontrarPessoaCpf(cpf) == null) {
            System.out.println("Professor inexistente! Tente novamente: ");
            System.exit(0);
        }

        Turma t = new Turma(nome, ano, sem, p);
        s.novaTurma(t);

        // Verifica se a turma foi criada
        if (t == null) {
            System.exit(0);
        }

        int tamanhoTurma = lerInteiro("Digite quantos alunos a turma tera: ");
        for (int i = 0; i < tamanhoTurma; i++) {
            String m = lerLinha("Digite a matricula do aluno: ");
            Aluno a = s.encontrarAluno(m);

            if (a != null) {
                t.adicionarAlunoTurma(a);
            } else {
                System.out.println("Aluno não encontrado!");
            }
        }

        cadastrarAvaliacoes(t, s);

    }

    public void cadastrarAvaliacoes(Turma turma, Sistema s) {
        turma.listarAvaliacoes();

        int qtdAvs = lerInteiro("Digite a quantidade de avaliações da turma: ");
        for (int i = 0; i < qtdAvs; i++) {
            int type = lerInteiro("Digite o tipo de avaliação, prova(1) ou trabalho(2)");

            String n = lerLinha("Digite o nome da avaliação: ");
            Data d = new Data(lerInteiro("Dia: "), lerInteiro("Mes: "), lerInteiro("Ano: "));
            int valor = lerInteiro("Digite o valor da avaliação: ");



            if (type == 1) {
                int qtdQuestoes = lerInteiro("Digite a quantidade de questões da prova: ");
                System.out.println(qtdQuestoes);
                Prova p = new Prova(n, d, valor, qtdQuestoes);

                ArrayList<Aluno> alunosMatriculados = turma.getAlunosMatriculados();
                for (Aluno a : alunosMatriculados) {
                    AlunoProva ap = new AlunoProva(a);
                    for (int k = 0; k < qtdQuestoes; k++) {
                        double n3 = lerInteiro("Digite a nota: ");
                        ap.addNotas(n3);

                    }
                    p.addAlunoProva(ap);
                }
                turma.addAvaliacao(p);
            }
            if (type == 2) {
                int maxIntegrantes = lerInteiro("Digite o numero maximo de integrantes: ");
                int qtdGrupos = lerInteiro("Digite a quantidade de grupos neste trabalho: ");

                Trabalho t = new Trabalho(n, d, valor, maxIntegrantes);

                for (int k = 0; k < qtdGrupos; k++) {
                    double nf = 0;
                    int qtdIntegrantes = lerInteiro("Digite a quantidade de integrantes do grupo: ");


                    String[] mats = new String[qtdIntegrantes];
                    for (int j = 0; j < qtdIntegrantes; j++) {
                        mats[j] = lerLinha("Digite a matricula do aluno: ");
                    }

                    nf = lerDouble("Nota final do grupo: ");

                    GrupoTrabalho gt = new GrupoTrabalho(nf);

                    for (String m : mats) {
                        Aluno a = s.encontrarAluno(m);
                        if (a == null) {
                            System.out.println("Aluno nao cadastrado!!!");
                        } else {
                            gt.addAlunosGrupo(a);
                        }
                    }
                    t.addGrupoTrabalho(gt);
                }
                turma.addAvaliacao(t);
            }
        }

    }

    public void listarTurmas(Sistema s) {
        s.listarTurmas();
    }

}
