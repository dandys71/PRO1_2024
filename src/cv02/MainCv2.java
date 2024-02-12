package cv02;

import cv02.model.IZvire;
import cv02.model.Kocka;
import cv02.model.Pes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainCv2 {
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        /*try{
            System.out.println("Zadej dělence: ");
            int d = input.nextInt();
            System.out.println("Zadej dělitele: ");
            int d2 = input.nextInt();
            int vysledek = vydel(d, d2);
            System.out.println("Výsledek dělení je: " + vysledek);

        }catch(InputMismatchException ex){
            System.out.println("Zadal jsi neplatnou hodnotu");
       }catch (ArithmeticException ae){
            System.out.println(ae.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("Aplikce pokrauje dále v běhu");*/
        IZvire[] zvirata = new IZvire[2];
        zvirata[0] = new Kocka();
        zvirata[1] = new Pes();

        for (int i = 0; i < zvirata.length; i++) {
            zvirata[i].udelejZvuk();
        }
    }

    private static int vydel(int c1, int c2) throws ArithmeticException{
        if(c2 == 0){
            throw new ArithmeticException("Nelze dělit nulou");
        }
        return c1 / c2;
    }

}
