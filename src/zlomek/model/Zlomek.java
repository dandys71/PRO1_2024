package zlomek.model;

import zlomek.util.ZlomekUtil;

//TODO cv2:
/*
zlomek udělat imutable (neměnný), odstranit settry
vyjímka při zadání nulového jmenovatele (try-catch, throw)
rozhraní, které bude definovat základní operace pro práci se zlomky (sčítání, odčítání, násobení, dělení)
metoda vracející desetinné vyjádření zlomku
* */
public class Zlomek implements IZlomek{
    private final int citatel;

    private final int jmenovatel;

    public Zlomek(int citatel, int jmenovatel)throws ArithmeticException{
        if(jmenovatel == 0){
            throw new ArithmeticException("Jmenovatel nemůže být nulový");
        }
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

    @Override
    public String toString() {
        return getCitatel() + " / " + getJmenovatel();
    }

    @Override
    public IZlomek vynasob(IZlomek z) {
        int novyCitatel = getCitatel() * z.getCitatel();
        int novyJmenovatel = getJmenovatel() * z.getJmenovatel();

        return new Zlomek(novyCitatel, novyJmenovatel);
    }

    @Override
    public IZlomek vydel(IZlomek z) {
        int novyCitatel = //todo;
        int novyJmenovatel = //todo;

        return new Zlomek(novyCitatel, novyJmenovatel);
    }
}
