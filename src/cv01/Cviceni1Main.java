package cv01;

/*
Pro lepší orientaci sledujte čísla u komentářu, ukazují Vám, jak se postupně kód tvořil
V rámci cvičení 1 si ukážeme:
- tvorbu tříd
- vytvoření instance třídy
- vytvoření vlastních konstruktorů
- princip zapouzdření (modifikátory přístupu)
- přístupové metody (gettery a settry)
- pomocnou třídu a statické metody
* */

import cv01.model.Osoba;

/**
    Třída, která bude obshovat spustitelnou metodu main
* */
public class Cviceni1Main {

    //spustitlená metoda main, v InteljIdea ji lze vytvořit zkratkou psvm
    public static void main(String[] args) {
        //11
        //vytvoření nové instance naší třídy je velmi podobné vytváření nových proměnných, například proměnnou typu String můžeme vytvořit takto
        String text = "Můj text";
        //skládá se tedy z datového typu (String) z libovolného názvu proměnné (text) z rovnítka (pro inicializaci hodnoty) a za ním pak vytvoření konkrétního textu

        //pokud vytvářím instanci třídy, datovým typem je právě daná třída (Osoba), opět následuje libovolný název proměnné
        //pro vytvoření nové instance naší třídy potřebujeme použít klíčové slovo new, za kterým následuje volání konstuktoru
        //my jsme si vytvořil konstuktory dva - jeden bez parametrů a druhý parametrický

        Osoba pepa = new Osoba();

        //u konstuktoru bez parametrů musíme atributy předat pomocí přístupových metod
        pepa.setJmeno("Josef");
        pepa.setPrijmeni("Novák");
        pepa.setRokNarozeni(1980);

        //zkouška vypsání věku
        System.out.println(pepa.getVek());

        //u parametrického konstuktoru můžu veškeré atributy předat v parametru
        Osoba karel = new Osoba("Karel", "Matoušek", 2000);

        //zkouška vypsání věku
        System.out.println(karel.getVek());
    }

}
