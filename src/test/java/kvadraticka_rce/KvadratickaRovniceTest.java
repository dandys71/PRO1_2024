package kvadraticka_rce;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KvadratickaRovniceTest {
    @Test
    void neplatnyAtributA(){
        Throwable t = assertThrows(IllegalArgumentException.class, () -> {
            new KvadratickaRovnice(0, 0, 0); //0 je u argumentu a neplatná
        });

        assertEquals("Argument a musí být různý od nuly", t.getMessage()); //můžeme otestovat, že to vyhodí i správnou zprávu
    }

    /*
    x2−11x+24=0;D=25;{3, 8};
    x2+9=0;D=-36;{v R nemá řešení}
    x2-6x+9=0;D=0;{3}
    * */

    @Test
    void testDiskriminantu(){
        KvadratickaRovnice r = new KvadratickaRovnice(1, -11, 24);
        assertEquals(25, r.vypoctiDiskriminant());
    }

    @Test
    void testDvaKoreny(){
        KvadratickaRovnice r = new KvadratickaRovnice(1, -11, 24);
        double[] k = r.vypoctiKoreny();
        assertEquals(8.0, k[0]);
        assertEquals(3.0, k[1]);
    }

    @Test
    void testJedenKoren(){ //respektive dva se stejnou hodnotou
        KvadratickaRovnice r = new KvadratickaRovnice(1, -6, 9);
        double[] k = r.vypoctiKoreny();
        assertEquals(3.0, k[0]);
        assertEquals(3.0, k[1]);
    }

    @Test
    void testNemaReseniVRealnychCislech(){
        Throwable t = assertThrows(ArithmeticException.class, () -> {
            new KvadratickaRovnice(1, 0, 9).vypoctiKoreny();
        });

        assertEquals("Kvadratická rovnice nemá řešení v reálných číslech", t.getMessage());
    }

    @Test
    void testDvaKorenyZaPouzitiTridyKoreny(){
        KvadratickaRovnice r = new KvadratickaRovnice(1, -11, 24);
        Koreny k = r.vypociKoreny();
        assertEquals(8.0, k.getK1());
        assertEquals(3.0, k.getK2());
    }

}