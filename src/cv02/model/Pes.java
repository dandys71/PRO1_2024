package cv02.model;

/*
4 viz. třída Kočka
* */
public class Pes implements IZvire{
    @Override
    public void udelejZvuk() {
        System.out.println("Haf"); //pes má jiný zvuk
    }
}
