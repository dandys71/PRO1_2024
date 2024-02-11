package zlomek.model;

import zlomek.util.ZlomekUtil;

//TODO cv2:
/*
zlomek udělat imutable (neměnný), odstranit settry
vyjímka při zadání nulového jmenovatele (try-catch, throw)
rozhraní, které bude definovat základní operace pro práci se zlomky (sčítání, odčítání, násobení, dělení)
metoda vracející desetinné vyjádření zlomku
* */
public class Zlomek{
    private int citatel;

    private int jmenovatel;

    public Zlomek(int citatel, int jmenovatel){
        int delitel = ZlomekUtil.zjistiNejvetsihoSpolecnehoDelitele(citatel, jmenovatel);

        this.citatel = citatel / delitel;
        this.jmenovatel = jmenovatel / delitel;
    }

    public int getCitatel() {
        return citatel;
    }

    public int getJmenovatel() {
        return jmenovatel;
    }

    public void setCitatel(int citatel) {
        this.citatel = citatel;
    }

    public void setJmenovatel(int jmenovatel) {
        this.jmenovatel = jmenovatel;
    }

}
