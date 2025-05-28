public class Data {

    private int dia, mes, ano;

    public Data(int d, int m, int a) {
        this.dia = d;
        this.mes = m;
        this.ano = a;
    }

    public void imprimir(Data d) {
        System.out.println(d.dia + "/" + d.mes + "/" + d.ano);
    }

    public boolean posterior(Data d2) {
        int diff = d2.ano - this.ano;

        if (diff > 0) {
            return true;
        } else if (diff == 0) {
            if (d2.mes - this.mes > 0) {
                return true;
            } else if (d2.dia - this.dia > 0) {
                return true;
            }
        }
        return false;
    }

    public int getDia() {
        return this.dia;
    }

    public int getMes() {
        return this.mes;
    }

    public int getano() {
        return this.ano;
    }

}
