package cv02.model;

public class Kocka implements IZvire{
    @Override
    public void udelejZvuk() {
        System.out.println("Mňau");
    }

    public void odpocivej(){
        System.out.println("odpočivám");
    }
}
