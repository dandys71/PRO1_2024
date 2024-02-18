package zlomek;

import zlomek.model.IZlomek;
import zlomek.model.Zlomek;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ZlomekApp {
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args)  {

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

    }
}
