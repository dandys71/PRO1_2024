package cv02.model;

/*4
* Třida kocka implementuje rozhrani IZvire pomocí klíč. slova implements
* Třída může implementovat nespočet rozhraní, které oddělujeme čárkou
* Rozhrani IZvire nam určuje, že je potřeba implementovat metodu udelejZvuk
* pomocí alt + Enter (musím mít kurzor vedle IZvire) můžu vybrat možnost implement methods, což mi předvytvoří metody, které je potřeba implementovat
* */
public class Kocka implements IZvire{
    @Override
    public void udelejZvuk() {
        System.out.println("Mňau");
    }

    public void odpocivej(){
        System.out.println("odpočivám");
    }
}
