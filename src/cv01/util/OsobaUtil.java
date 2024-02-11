package cv01.util;

import java.time.Year;

/***
 *  Pomocná třída pro třídu Osoba
 *  pomocné třídy zpravidla obsahují statické metody
 */
public class OsobaUtil {

    /***
     * Pomocná metoda pro vypočtení věku
     * @param rokNarozeni
     * @return vypocteny vek na základě rokuNarozeni a aktuálního roku
     */
    //8
    public static int vypoctiVek(int rokNarozeni){
        return Year.now().getValue() - rokNarozeni;
    }
}
