package kvadraticka_rce;

//pouze pro ukázku alternativní možnosti, jak vrátit kořeny
public class Koreny {
    private double k1;

    private double k2;


    //dva konstruktory jeden bezparametrický a druhý, který přijímá oba dva kořeny
    public Koreny() {
    }

    public Koreny(double k1, double k2) {
        this.k1 = k1;
        this.k2 = k2;
    }

    //nezapomenout na přístupové metody - atributy k1 a k2 jsou privátní (zapouzdřené)

    public double getK1() {
        return k1;
    }

    public void setK1(double k1) {
        this.k1 = k1;
    }

    public double getK2() {
        return k2;
    }

    public void setK2(double k2) {
        this.k2 = k2;
    }
}
