package zlomek.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZlomekTest {

    //cv3: vytvoř testy na ověření funkčnosti všech početních úloh se zlomky a na korektní výstup metody toString()
    @Test
    void testCitatel(){
        Zlomek t = new Zlomek(9, 3);
        assertEquals(3, t.getCitatel());
    }

    @Test
    void testJmenovatel(){
        Zlomek t = new Zlomek(5, 20);
        assertEquals(4, t.getJmenovatel());
    }

    @Test
    void nulovyJmenovatel(){
        assertThrows(ArithmeticException.class, () -> {
            new Zlomek(1, 0);
        });
    }

    @Test
    void testScitani(){
        Zlomek z1 = new Zlomek(2, 3);
        Zlomek z2 = new Zlomek(15, 5); //3 / 1
        assertEquals("11 / 3", z1.secti(z2).toString());
    }

    @Test
    void testOdcitani(){
        Zlomek z1 = new Zlomek(2, 3);
        Zlomek z2 = new Zlomek(15, 5); //3 / 1
        assertEquals("-7 / 3", z1.odecti(z2).toString());
    }
    @Test
    void testNasobeni(){
        Zlomek z1 = new Zlomek(2, 3);
        Zlomek z2 = new Zlomek(15, 5); //3 / 1
        assertEquals("2 / 1", z1.vynasob(z2).toString());
    }
    @Test
    void testDeleni(){
        Zlomek z1 = new Zlomek(2, 3);
        Zlomek z2 = new Zlomek(15, 5); //3 / 1
        assertEquals("2 / 9", z1.vydel(z2).toString());
    }

}