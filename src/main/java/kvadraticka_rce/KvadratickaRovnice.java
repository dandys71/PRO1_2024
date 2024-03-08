package kvadraticka_rce;
//1) Vytvořte třídu pro kvadratickou rovnici (přepokládejme, že bude zadána vždy v obecném tvaru ax^2 + bx + c = 0),
//5) Nechte třídu pro kvadratickou rovnici implementovat tento interface
public class KvadratickaRovnice implements IKvadratickaRovnice { //pomocí alt+enter nechám naimplementovat metody
    //tato třída bude mít atributy a, b, c
    //2) a,b,c jsou reálná čísla -> double, případně float
    private final double a; //atributy můžeme označit jako final (konstanta), jejich hodnota je předána v konstruktoru a pak již nelze měnit
    //vhodné pokud chceme, aby byly proměnné neměnné

    private final double b;

    private final double c;


    //3) Atribut a musí být různý od nuly
    //vytvoříme konstruktor, který bude přijímat všechny tři atributy - a, b, c
    //nezapomeňte se podívat na testy
    public KvadratickaRovnice(double a, double b, double c) throws IllegalArgumentException {
        if(a == 0){
            throw new IllegalArgumentException("Argument a musí být různý od nuly"); //pokud je vyhozena vyjímka, kód se dál nevykonává, pokud výjimka není při volání konstruktoru ošetřena (try-catch), spadne celá aplikace
        }
        //pokud bude vyhozena výjimka, tento kód se již nevykoná
        this.a = a;
        this.b = b;
        this.c = c;
    }


    //6) vzorce pro výpočet diskriminantu a kořenů rovnice si případně najděte na internetu
    // (mocina-> Math.pow(zaklad - double, exponent - double); odmocnina -> Math.sqrt(double);
    @Override
    public double vypoctiDiskriminant() { //není potřeba zadávat vstupní argumenty a, b, c, vše je přístupné z aktuální třídy KvadratickaRovnice skrze atributy
        //D = b^2 - 4 * a * c
        return Math.pow(b, 2) - 4 * a * c;
    }

    /*
    7) U kořenů obcecně rozlišujeme tři stavy:
    D > 0 - dva různé reálné kořeny
    D = 0 - dva stejné realné kořeny
    D < 0 - nemá řešení v reálných číslech (vhodné vyhodit výjimku, nezapomenout přidat do hlavičky metody, že může vyhazovat výjimku)
     */
    @Override
    public double[] vypoctiKoreny() {
        double[] koreny = new double[2]; //můžu mít dva kořeny, 1. na indexu 0 a 2. na idnexu 1
        double diskriminant = vypoctiDiskriminant(); //pokud používám nějakou hodnotu vícekrát, je vhodné si ji uložit do pomocné proměnné
        if(diskriminant < 0){
            throw new ArithmeticException("Kvadratická rovnice nemá řešení v reálných číslech");
        }else{ //je roven 0 nebo je větší jak 0
            //pokud je d = 0, budou v obou kořenech totožné hodnoty, což nám nevadí -> lepší varianta, než tam nechat výchozí 0
            koreny[0] = (-b + Math.sqrt(diskriminant)) / (2 * a);
            koreny[1] = (-b - Math.sqrt(diskriminant)) / (2 * a);
        }
        return koreny; //vrátíme proměnnou kořeny jako výsledek
    }

    //stejné jak metoda výše, jen využívá pro vracení výsledku vlastní třídu
    @Override
    public Koreny vypociKoreny() {
        double diskriminant = vypoctiDiskriminant(); //pokud používám nějakou hodnotu vícekrát, je vhodné si ji uložit do pomocné proměnné
        if(diskriminant < 0){
            throw new ArithmeticException("Kvadratická rovnice nemá řešení v reálných číslech"); //pokud vyhodím výjimku kód dále nepokračuje
        }else{ //je roven 0 nebo je větší jak 0
            //pokud je d = 0, budou v obou kořenech totožné hodnoty, což nám nevadí -> lepší varianta, než tam nechat výchozí 0
            double prvniKoren = (-b + Math.sqrt(diskriminant)) / (2 * a);
            double druhyKoren = (-b - Math.sqrt(diskriminant)) / (2 * a);
            return new Koreny(prvniKoren, druhyKoren);
        }
    }

    //můžeme si nechat vytvořit gettery na atributy (pozor setry ne, jelikož atributy a, b, c jsou označené jako final)

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
}
