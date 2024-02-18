package zlomek.util;

public class ZlomekUtil {
    /***
     * Pomocí Euklidova algoritmu zjistí největšího společného dělitele dvou čísel
     * @return
     */
    public static int zjistiNejvetsihoSpolecnehoDelitele(int u, int w){
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
