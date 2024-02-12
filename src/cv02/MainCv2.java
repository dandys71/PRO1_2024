package cv02;

import cv02.model.IZvire;
import cv02.model.Kocka;
import cv02.model.Pes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainCv2 {
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        /*
        1
        Obsluha vyjímek
        říkali jsme si, že některý kód může být "nebezpečný" a jeho vykonávání může skončit chybou
        nebezpečný kód by měl být umístěn v try blocku, který umožňuje na výjimky vzniklé uvnitř toho bloku reagovat a ochránit tak aplikaci před pádem
        pomocí catch bloku, kterému na vstupu předáme, jaké výjimku chceme odchytávat
        v tomto catch bloku pak na výjimku patřičně reagujeme (výpis hlášky uživateli, zopakování předešlé akce, vypsání stacktrace)
        catch bloků může být neomezeně, což nám umožňuje různé reakce na různé výjimky
        pozor ovšem na pořadí těchto catch bloků
        pokud bychom například odchytávali obecnou Exception (což je předek všech výjimek), daná chyba bude vždy odchycena v tomto bloku a do dalších se nikdy nedostane
        try-catch nám umožňuje ještě přidat tzv. finally blok, který se vykoná vždy nehledě na to, zda kód v try bloku byl úspěšně proveden, nebo byla během vykonávání vyvolaná výjimka
       finally mívá většinou využití například pro odpojení databázového spojení, které musí být ukončeno jak při úspěšném, tak i neuspěšném provedení operace
         */

        try{
            System.out.println("Zadej dělence: ");
            int d = input.nextInt();
            System.out.println("Zadej dělitele: ");
            int d2 = input.nextInt();
            int vysledek = vydel(d, d2);
            //pokud uživatel zadá neplatnou hodnotu (např. znak, nebo 0 do jmenovatele) bude vyhozena vyjímka a kód níze se již nevykoná
            System.out.println("Výsledek dělení je: " + vysledek);
        }catch(InputMismatchException ex){
            //vypsání hlášky pro uživatele
            System.out.println("Zadal jsi neplatnou hodnotu");
            //vypsání stackTrace - slouží hlavně pro ladění (zapisovat pouze do logu (ne do konzole), uživatel by neměl stackTrace vidět)
            ex.printStackTrace();
       }catch (ArithmeticException ae){
            System.out.println(ae.getMessage());
            ae.printStackTrace();
        }catch(Exception e){ //pokud bycho tuto obecnou výjimku dali na první misto, odchytila všechny vzniklé výjimky
            System.out.println(e.getMessage());
            e.printStackTrace();
        }finally {
            System.out.println("Děkuji za použití mé aplikace...");
        }
        //pokud je tato hláška vypsána, znamená to, že jsme správně ochytyli všechny výjimky a ochránili jsme aplikaci před pádem
        System.out.println("Aplikace pokračuje stále v běhu");

        //Konec 1

        /*5. Interface - rozhraní
        * viz. IZvire, Kocka, Pes
        * U tříd Kocka a Pes jsme implementovali rozhraní IZvire,
        * proto víme, že tyto třídy musí obsahovat metodu udelejZvuk, kterou můžeme u obou objektů zavolat
        * */
        Pes p = new Pes();
        p.udelejZvuk();
        Kocka k = new Kocka();
        k.udelejZvuk();

        /*
        Díky tomu, že tyto třídy implemetují rozhraní IZvire, můžu novou instanci uložit nejden do objektu dat. typu Kocka a Pes,
        ale stejně tak i do objektu typu IZvire
        to mi umožňuje stále volat metodu udelejZvuk, které dané rozhraní má
        zajimavé je, že oba dva objekty jsou typu IZvire, nicméně při zavolání udelejZvuk se pokaždé metoda chová jinak (vypíše jiný řetězec)
        toto chování je typické pro tzv. Polymorfismus, kdy jedna totožná metoda má odlišné chování
        Pozor ovšem na to, pokud má třída nějaké operace, atributy navíc, uložením instance do rozhraní o tyto metody přijdu
        například kočka má vlastní metodu odpocivej (kterou IZvire nenabízí), a proto není možné tuto metodu zavolat
        * */
        IZvire iPes = new Pes();
        IZvire iKocka = new Kocka();
        iPes.udelejZvuk();
        iKocka.udelejZvuk();

       // iKocka.odpocivej(); //není možné zavolat, iKocka je typu IZvire a tento interface metodu odpocivej nemá...


        /*
        Tím, že můžu instance odličných objektů (Kočka a Pes) nahrát do rozhraní, které obě třídy impementují
        můžu tyto různorodě objekty nahrát do společného pole datového typu IZvire
        To pak například mohu procházet a volat operace, které dané rozhraní nabízí (udelejZvuk())
        V tomto poli můžu mít celé ZOO zvířat, a každé z nich bude mít jiné chování u metody udelejZvuk
        Z UPROM již víte, že pole může být pouze jednoho datového typu, například int a není možné do takového pole nahrát cokoliv jiného
        rozhraní je jeden z způsobu, jak lze toto omezení obejít
        * */

        //tvorba pole vlastní objektů je obdobná jako například pole integerů
        //int[] cisla = new int[2]
        //takže datový typ, [], název pole, =, vytvoření nového pole dané velikosti daného datového typu
        IZvire[] zvirata = new IZvire[2];
        zvirata[0] = new Kocka(); //na nultou pozici uložím kočku
        zvirata[1] = new Pes(); //na prvou pozici uložím psa

        //for cyklem projdu všechny zvířata v poli zvirata
        for (int i = 0; i < zvirata.length; i++) {
            zvirata[i].udelejZvuk(); //každé zvíře udělá jiný zvuk - polymorfismus
        }
    }

    //2. tvorba metody pro dělení dvou čísel
    /***
     *
     * Metoda sloužící pro celočíselné dělení dvou čísel
     * @param c1
     * @param c2
     * @return výsledek celočíselného dělení c1 a c2
     * @throws ArithmeticException
     */
    //2.3 do hlavičky metody bych měl přidat informaci, že tato metoda obsahuje nebezpčný kód a může vyhodit nějakou výjimku
    //to lze pomocí slovíčka throws
    //za toto slovo pak vypíšu čárkou oddělené výjimky, které může metoda vyhodit, v našem případě se jedná pouze o ArithmeticException
    private static int vydel(int c1, int c2) throws ArithmeticException{
        if(c2 == 0){ //2. 1 - při dělení neumíme dělit nulou, pokud je tedy dělitel nulový, vyhodíme novou výjimku
            //výjimka se vyhazuje pomocí klíč.slova throw
            //poté je opět nutné vytvořit novou instanci výjimky (pomocí new)
            //výjimka ArithmeticException má konkrétně 2 konstuktory
            //prázdný - žádné parametry
            //nebo konstuktoru přijímací zprávu, kterou je pak možné získat pomocí metody getMessage()- například v catch bloku
            //v našem případě jsme vytvořili novou instanci výjimky, která má parametr message nastaven na "Nelze dělit nulou"
            //throw - vyhození výjimky ukončí standarní vykonávání kódu, a proto se kód, který je pod výjimkou, která byla vyhozena, nevykoná
            throw new ArithmeticException("Nelze dělit nulou");
        }

        //2.2 pokud nebyla vyhozena výjimka vrátím výsledek celočíselného dělení
        return c1 / c2;
    }

}
