package zlomek;

import zlomek.model.Zlomek;

public class ZlomekApp {
    public static void main(String[] args) {
        Zlomek z1 = new Zlomek(10, 5);
        System.out.println(z1);
        System.out.println();

        Zlomek z2 = new Zlomek(456, 321);
        System.out.println(z2);
    }
}
