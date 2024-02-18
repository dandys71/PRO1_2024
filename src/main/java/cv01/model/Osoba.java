package cv01.model;

import cv01.util.OsobaUtil;

public class Osoba {
    //1
    //v programování aplikujeme tzv. abstrakci, tzn. sledujeme pouze vlastnosti (atributy), které nás zajímají pro řešení našeho problému
    //například naše třída osoba bude obsahovat pouze atributy: jmeno, prijmeni, vek a rok narozeni
    //stejne tak by mohla obsahovat vahu, vysku, barvu_oci, atd. což jsou, ale atributy, které pro řešení našeho problému nemají žádný význam, budeme je tedy ignorovat

    //2
    //na atributy bychom měli aplikovat tzv. princip zapouzdření, kdy si objekt chrání svůj vnitřní stav
    // Tento stav atributů je pak možné měnit a číst pomocí tzv. přístupových metod
    //v Javě pro to existuje několik modifikátorů přístupu: private, protected, public a private-package
    //private-package - umožňuje přístup třídám v rámci stejného package - je defaultní (bude použit v případě, že před atribut žádný modifikátor neuvedeme)
    //protected - mohou k nim přistupovat i potomci třídy (dědění)
    //public - lze k nim přistupovat z libovolné třídy
    //private - lze k nim přistupovat pouze z třídy samotné
    //v rámci principu zapouzdření používáme u atributů převážně modifikátor private
    private String jmeno;

    private String prijmeni;

    private int vek;

    private int rokNarozeni;

    //3
    //každá třida by měla mít tzv. konstruktor, ten bývá zpravidla public (jinak by k němu nemohli přistupovat ostatní třídy) a slouží k vytváření nových instancí (objektů)
    //pokud nevytvoříme žádný konsturkutor, vytvoří se defaultní, který nepříjímá žádné parametry
    //pokud ovšem nějaký konstuktor vytvoříme, defaultní již nepůjde použit a budeme si jej muset v případě potřeby vytvořit sami
    public Osoba() {
    }

    //4
    //vlastní konstuktory nám ulehčují vytváření nových instancí (není potřeba vše nastavovat pomocí přístupových metod)
    //konstuktor začíná zpravidla velkým písmenem (stejně jako názvy tříd)
    //poté funguje obdobně jako metody, tzn. umožňuje nám definovat vstupní parametry
    //konstruktor vždy vrací novou instanci objetu, proto není možné definovat konstuktoru datový typ
    //třída může mít libovolné množství konstuktoru, ALE musí se odlišovat v parametrech (různé datové typy, jiné pořadí parametrů)
    //pokud bychom měli 2 konstuktory se stejnou hlavičkou, ale rozdílným tělem, nebylo by jednozačné, který chceme volat
    //momentálně tedy máme dva použitelné konstuktory - jeden bez parametrů (výše) a druhý s parametry jmeno, prijmeni a vek (níže)
    public Osoba(String jmeno, String prijmeni, int rokNarozeni) {
        //většinu se v konstuktoru používají stejné pojmenování pro parametry jako pro atributy třídy
        //pokud bychom ovšem zapsali např. jmeno = jmeno, nebylo by jasné, zda chceme nastavit hodnotu z parametru do atributu či opačně
        //k rozlišení nám pomůže klíč. slovo this, které se odkazuje na aktuální třídu (tedy Osoba)
        //tím jasně definujeme že do atributu chceme nahrát hodnotu z parametru
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;

        this.rokNarozeni = rokNarozeni;

        //10
        setVek(); //todo: POZOR nesmíme zapomenout zavolat pro výpočet aktuální věku, zde je důležité, aby se volání provádělo po nastavení roku narození

        //TODO : lepším způsobem by bylo zavolat setter pro rokNarozeni, který již metodu setVek volá...
        //setRokNarozeni(rokNarozeni);
    }

    //5
    //určitě budeme chtít, aby pro ostatní třídy byly viditelné hodnoty atributů jmeno, prijmeni, vek a rokNarozeni
    //k tomuto účelu budeme muset vytvořit tzv. přístupové metody - konkrétně gettery
    //modifikátor přístupů u getterů nastavujeme zpravidla public (veřejný), mohou ovšem nastat situace, kdy nechci, aby některý z atributů třídy byl pro venek viditlený --> private
    //hlavička getteru se tedy skládá z modifikátoru přístupu, návratového datového typu (ten je stejný jako datový typ konkrétního atributu) a názvu, který je zpravidla getNazevAtributu() - camel Case
    //gettery slouží pouze pro čtení hodnoty, a proto nemají žádné parametry
    //v těle getru pak pouze pomocí return vracíme hodnotu příslušného atributu
    public String getJmeno(){
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public int getVek() {
        return vek;
    }

    public int getRokNarozeni() {
        return rokNarozeni;
    }

    //6
    //pro nastavování hodnoty slouží tzv. settery
    //u nich bývá modifikátor přístupu různorodý na základě toho, zda chceme, aby mohla být hodnota měněna jinými třidami či nikoliv
    //hlavička setteru se tedy skládá z modifikátoru přístupu, návratového typu (který bývá zpravidla void), názvu, který odpovídá setJmenoAtributu, a v závorkách definované parametry
    //vstup bývá zpravidla jeden a odpovídá opět datovému typu konkrétního atributu
    public void setJmeno(String jmeno) {
        //všimněte si, že opět máme stejně pojmenované atributy a parametry a je nutné je rozlišit pomocí this
        this.jmeno = jmeno;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public void setRokNarozeni(int rokNarozeni) {
        this.rokNarozeni = rokNarozeni;
        //9
        setVek();//nesmíme zapomenout zavolat metodu setVek, která se postará o výpočet nového věku
    }

    //7
    //zde jako u jediného setteru máme modifikátor private
    //je to z důvodů, že chceme, aby atributy v třídě byly pokud možno konzistentní a rokNarozeni tedy odpovídal věku
    //proto nechceme, aby někdo z "venku" měnil hodnotu atributu vek
    //hodnotu si sami vypočteme na základě aktuálního roku a rokuNaroku narozeni (setter tedy nebude příjímat žádné parametry)
    private void setVek() {
        //pro pomocné výpočty jsme si vytvořili tzv. util třídu
        //ta bude obsahovat statické metody
        //rozdíl mezi statickými metodami a nestatickými je ten, že statické metody, nepotřebují vytvářet nové instance a existují po celou dobu běhu programu
        //takto můžeme korektně volat statickou metodu vypoctiVek, které v parametru předáme rokNarozeni
        this.vek = OsobaUtil.vypoctiVek(getRokNarozeni());

        //pokud by metoda uvnitř třídy nebyla statická volání této metody by vypadalo nějak takto:
        /*
        OsobaUtil util = new OsobaUtil();
        this.vek = util.vypoctiVek(getRokNarozeni());
        */
    }

}
