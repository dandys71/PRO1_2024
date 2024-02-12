package zlomek;

import zlomek.model.IZlomek;
import zlomek.model.Zlomek;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ZlomekApp {
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args)  {

        Zlomek z2 = new Zlomek(10, 5);


        Zlomek z1 = new Zlomek(3, 9);


        IZlomek vysledek = z1.vynasob(z2);

        System.out.println(vysledek);

/*
        try {
            System.out.println("Zadej čitetel: ");
            int citatel = input.nextInt();
            System.out.println("Zadej jmenovatel: ");
            int jmenovatel = input.nextInt();

            Zlomek z = new Zlomek(citatel, jmenovatel);
            System.out.println("Dostal jsem se až sem");
        }catch (ArithmeticException ae){
            System.out.println(ae.getMessage());
            ae.printStackTrace();
        }catch (InputMismatchException ie){
            System.out.println("Nezdal jsi správný formát");
        }finally {
            System.out.println("Děkuji za vytvoření zlomku15");
        }

        System.out.println("Kod stále běží");*/

    }
}
