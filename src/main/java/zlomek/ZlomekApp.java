package zlomek;

import zlomek.model.IZlomek;
import zlomek.model.Zlomek;

import java.util.*;


public class ZlomekApp {
    private static final Scanner input = new Scanner(System.in);

    private static final Random random = new Random();
    public static void main(String[] args)  {
/*
        Zlomek z1 = new Zlomek(3, 9); //zkrácený tvar: 1 / 3

        Zlomek z2 = new Zlomek(10, 5); //zkrácený tvar: 2 / 1

        // Zkouška námi implementovaných operací z IZlomek
        IZlomek vynasob = z1.vynasob(z2); //2 / 3
        System.out.println("Výsledek nasobeni je: " + vynasob);
        IZlomek vydel = z1.vydel(z2); //1 / 6
        System.out.println("Výsledek dělení je: " + vydel);
        IZlomek secti = z1.secti(z2); //7 / 3
        System.out.println("Výsledek sčítání je: " +  secti);
        IZlomek odecti = z1.odecti(z2); //-5 / 3
        System.out.println("Výsledek dodčítání je: " + odecti);


        //načtení zlomku od uživatele včetně ošetření výskytu všech možných výjimek
        try {
            System.out.println("Zadej čitetel: ");
            int citatel = input.nextInt();
            System.out.println("Zadej jmenovatel: ");
            int jmenovatel = input.nextInt();

            Zlomek z = new Zlomek(citatel, jmenovatel);
            //pokud při zadávání čísla nebo při zadání nulového jmenovatele, se kód dále nedostane a zpráva níže s novým zlomkem nebude vypsána
            System.out.println("Vámi vytvořený zlomek: " + z);
        }catch (ArithmeticException ae){
            System.out.println(ae.getMessage());
            ae.printStackTrace();
        }catch (InputMismatchException ie){
            System.out.println("Nezdal jsi správný formát");
            ie.printStackTrace();
        }catch (Exception e){ //to, co neodchytí dva předchozí catche, odchytí tento obecný
            System.out.println("Vyskatla se jiná neznáma chyba");
            e.printStackTrace();
        } finally {
            System.out.println("Děkuji za vytvoření zlomku");
        }

        //zkouška, že po odchycení výjimku bude tato hláška vypsána
        System.out.println("Kod stále běží");
*/

        //Cvičení 3
        //Kolekce, která je vnitřně derinovaná polem (datového typu, který předáme v <>)
        //araylist je pružnější než samotné pole, které má předem danou velikost a nelze měnit
        //vtniřně funguje tak, že pokud vyčerpá velikost pole, vytvoří pole větší a do něj nahraje hodnoty z předchozího pole
        //umožňuje přímý přístup k položkám pomocí metody get(int index)
        //přidávat prvky lze pomocí metody add a mazat pomocí metody remove
        //pomocí metody size() lze zjisit aktuální obsazenost kolekce
        //do konsturkoru můžeme předat výchozí kapacitu (např. když předem víme, že hodnot bude hodně)
        //tím zamezíme tomu, aby se při pridání hodnoty několikrát vytvářelo nové pole a probíhalo kopírování hodnot se starého do nového
        //např new ArrayList<>(500);
        ArrayList<Zlomek> zlomky = new ArrayList<>();

        //vygenerujte 10 náhodných zlomků a přidejte je do kolekce
        for (int i = 0; i < 10; i++) {
            int c = random.nextInt(30); //vygeneruji náhodné číslo pro čitatel
            int j = random.nextInt(30) + 1; //vygeneruji náhodné číslo pro jmenovatel (pozor jmenovatel nemůže být nulový, proto + 1)
            Zlomek novyZlomek = new Zlomek(c, j); //vytvořím instanci nového zlomku s parametry citatele a jmenvovatele
            zlomky.add(novyZlomek); //tento nový zlomek přidám do kolekce
        }
        //poznámka: na cvičení jsme používali hranici 100 místo 30
        //to nám poté při sčítání způsobilo tzv. přetečení integeru, což mohlo mít za následek, že se zde objevily i záporné hodnoty
        //pokud dojde k přeteční datového typu, výsledky pak nejsou korektní
        //tomuto by šlo například předejít tak, že datové typy u citatele a jmenovatele změníme z int na long

        //zlomky mohu přidávat i na začátek arraylistu
        //při přidávání na začátek arraylistu se však musí přesunout ostatní hodnoty o pozici dále
        zlomky.add(0, new Zlomek(1, 1));

        //provedte součet všech zlomků v tomto poli
        IZlomek pomocnyZlomek = zlomky.get(0);
        for (int i = 1; i < zlomky.size(); i++) {
            pomocnyZlomek = pomocnyZlomek.secti(zlomky.get(i));
        }

        //je možná i varianta, že pomocnyZlomek bude dat. typu Zlomek
        //při nahrávání hodnoty do zlomku, však musím výsledek scitani (což je nový objekt datového typu IZlomek) přetypovat na zlomek
        //pomocnyZlomek = (Zlomek) pomocnyZlomek.secti(zlomky.get(i));

        System.out.println("Součet je: " + pomocnyZlomek);

        //dalším typem kolekce je tzv. spojový seznam (LinkedList), kdy si každý
        //uzel udržuje odkaz na následující uzel (případně i na předchozí)
        //pohyb v rámci LinkedListu funguje, takže sekvenčně procházíme všechny uzly, dokud nenarazíme na hledanou hodnot
        LinkedList<Zlomek> zlomkyLinked = new LinkedList<>();

        //přidání zlomků pomocí metody add, addFirst, addLast, metody add a addLast jsou ekvivaletní (add tedy standardně přidává nakonec)
        zlomkyLinked.add(new Zlomek(1,1));
        zlomkyLinked.addFirst(new Zlomek(3, 5));
        zlomkyLinked.addLast(new Zlomek(5, 4));

        //hodnoty lze získavat obdobně jako u arraylistu pomocí metody get()
        //nicméně přístup není přímý jako u arraylistu, tzn. nedostanu se rovnou na konkrétní index
        //ale musí se projít všechny uzly, které před uzlem s daným indexem jsou
        //linkedlist je tedy kolekce, která je více vhodná pro množiny, které budeme chtít vždy procházat celé
        Zlomek z = zlomkyLinked.get(2);
    }
}
