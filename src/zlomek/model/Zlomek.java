package zlomek.model;

import zlomek.util.ZlomekUtil;

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
