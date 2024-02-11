package zlomek.model;

import zlomek.util.ZlomekUtil;

public class Zlomek {
    private int citatel;

    private int jmenovatel;

    public Zlomek(int citatel, int jmenovatel) {
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
