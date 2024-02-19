package zlomek.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZlomekTest {

    //cv3: todo vytvoř testy na ověření funkčnosti všech početních úloh se zlomky a na korektní výstup metody toString()
    @Test
    void testCitatele(){
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

}