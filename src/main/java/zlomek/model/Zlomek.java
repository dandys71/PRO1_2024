package zlomek.model;

import zlomek.util.ZlomekUtil;

public class Zlomek implements IZlomek{
    private final int citatel;

    private final int jmenovatel;

    //cv3: zajisti, aby jmenovatel nebyl záporný a aby do metody pro zjištění nejvěšího společného dělitele vstupovaly pouze kladné parametry
    public Zlomek(int citatel, int jmenovatel)throws ArithmeticException{
        if(jmenovatel == 0){
            throw new ArithmeticException("Jmenovatel nemůže být nulový");
        }
        if(jmenovatel < 0){
            jmenovatel = -jmenovatel; //případně jmenovatel * (-1)
            citatel = -citatel; //převedu zápor z jmenovatele do čitatele (pokud už by čitatel záporný před tím stane se zlomek kladným, tzn. z -3 / -9 se stane 3 / 9)
        }
        int delitel;

        //zajistím aby do metody vstupovaly pouze kladné hodnoty
        //u jmenovatele to mám již zajištěné a jediné co může být záporné je čitatel
        //pokud bude čitatel záporný přidáním znamnánka - z něj udělám kladný (případně * (-1))
        //toto znamená změní pouze hodnotu v parametru a nepřepíše hodnotu v proměnné
        if(citatel < 0){ //citatel je záporný,musím před voláním hodnotu upravit
            delitel = ZlomekUtil.zjistiNejvetsihoSpolecnehoDelitele(-citatel, jmenovatel);

        }else{ //citatel není záporný, mohu volat bez úprav
            delitel = ZlomekUtil.zjistiNejvetsihoSpolecnehoDelitele(citatel, jmenovatel);

        }
        //todo otázka: Co se stane pokud čitatel bude nula?

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
        int novyCitatel = getCitatel() * z.getJmenovatel();
        int novyJmenovatel = getJmenovatel() * z.getCitatel();

        return new Zlomek(novyCitatel, novyJmenovatel);
    }

    @Override
    public IZlomek secti(IZlomek z) {
        int novyCitatel = (getCitatel() * z.getJmenovatel()) + (z.getCitatel() * getJmenovatel());
        int novyJmenovatel = getJmenovatel() * z.getJmenovatel();

        return new Zlomek(novyCitatel, novyJmenovatel);
    }

    @Override
    public IZlomek odecti(IZlomek z) {
        int novyCitatel = (getCitatel() * z.getJmenovatel()) - (z.getCitatel() * getJmenovatel());
        int novyJmenovatel = getJmenovatel() * z.getJmenovatel();

        return new Zlomek(novyCitatel, novyJmenovatel);
    }
}
