package zlomek.util;

public class ZlomekUtil {
    /***
     * Pomocí Euklidova algoritmu zjistí největšího společného dělitele dvou čísel
     * @return
     */
    //cv3: ošetřete, aby při zadání nepřirozeného čísla v parametrech u a w došlo k vyhození výjimky IllegalArgumentException
    public static int zjistiNejvetsihoSpolecnehoDelitele(int u, int w) throws IllegalArgumentException{
        if(u <= 0 || w <= 0){
            throw new IllegalArgumentException("Hodnoty v parametrech musí být přirozené číslo");
        }
        //pomocí Euklidova
        int r = w;
        while(w != 0){
            r = u % w;
            u = w;
            w = r;
        }
        return u;
    }
}
