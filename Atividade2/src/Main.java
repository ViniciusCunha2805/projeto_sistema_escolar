public class Main {
    public static void main(String[] args) {
        int choice;
        Sistema s = new Sistema();
        Entrada ent = new Entrada();

        do {
            choice = ent.menu();
            if (choice == 1) {
                ent.cadastrarProfessor(s);
            } else if (choice == 2) {
                ent.cadastrarAluno(s);
            } else if (choice == 3) {
                ent.cadastrarTurma(s);
            } else if (choice == 4) {
                ent.listarTurmas(s);
            } else {
                System.exit(0);
            }
        } while(choice != 0);

    }
}