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

        //cv3: Co se stane pokud čitatel bude nula? metoda pro zjištění největšího společného dělitele vyhodí výjimku
        //--> ošetřit, aby v případě, že čitatel bude nula, nebude použita metoda pro hledání spol. dělitele a zlomek se tedy nebude krátit

        //cv3: do delitele nahraji defaultní hodnotu 1
        int delitel = 1;


        //zajistím aby do metody vstupovaly pouze kladné hodnoty
        //u jmenovatele to mám již zajištěné a jediné co může být záporné je čitatel
        //pokud bude čitatel záporný přidáním znamnánka - z něj udělám kladný (případně * (-1))
        //toto znamená změní pouze hodnotu v parametru a nepřepíše hodnotu v proměnné
        if(citatel < 0){ //citatel je záporný,musím před voláním hodnotu upravit
            delitel = ZlomekUtil.zjistiNejvetsihoSpolecnehoDelitele(-citatel, jmenovatel);

            //místo else použiji else-if, kde se omezím na citatel > 0
        }else if(citatel > 0){ //citatel není záporný, mohu volat bez úprav
            delitel = ZlomekUtil.zjistiNejvetsihoSpolecnehoDelitele(citatel, jmenovatel);

        }
        //jelikož v případě nulového čitatele nebude ani jedna podmínky splněna, zůstane v děliteli defaultní hodnota = 1

        //dělení 1, nám hodnotu zlomku nijak nezmění ;)
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


    //cv3: vytvořte metodu pro sparsování textu na zlomek (na základě ukázky z cv04)

    public static Zlomek parse(String input) throws NumberFormatException {
        //citalel / jmenovatel: 9 / 3
        //obsahuje vstupní string vůbec / - pokud ne, není to platný vstup a vyhodím výjimku
        if(input.contains("/")) {
            String[] values = input.split("/"); //[9,3]

            //případně lze vstup ověřit získáním velikosti pole. Pokud je prázdné znamená to, že splitování podle lomítka vrátilo pole o velikosti jedna, kde je jedinou hodnotou celý řetězec
            /*
            if (values.length == 1)
                throw new NumberFormatException("Nesprávný formát zlomku. Použijte tvar a/b");
                */

            //získané hodnoty z pole values se pokusím převést na Integer, ještě před tím však raději zavolám metodu trim(), která odstraní přebytečné mezery před a za číslem
            //pokud hodnoty před nebo lomítek nebudou číslo, metoda parseInt vyvolá též vyjímku NumberFormatException
            //zde pouze přidávám do hlavičky metody (throws NumberFormatException)
            //ošetření se pak musí udělat v místě, kde je tato metoda volána (v našem případě ZlomekApp)
            int citatel = Integer.parseInt(values[0].trim());
            int jmenovatel = Integer.parseInt(values[1].trim());

            return new Zlomek(citatel, jmenovatel);
        }else{
            throw new NumberFormatException("Nesprávný formát zlomku. Použijte tvar a/b");
        }
    }

    //cv3: Přetižte již implementované metody vynasob, vydel, secti a odecti, tak aby přijimály celé číslo
    //výpočet upravte, tak aby byl korektní (tzn. např. číslo 5 si lze představit jako 5/1 - pět jednin)
    //nezapomeňte vytvořit testy
    public IZlomek vynasob(int i) {
        int novyCitatel = getCitatel() * i;// 5 * citatel
        int novyJmenovatel = getJmenovatel() /* *1 */;// s jedninou nemá smysl pronásobovat, jelikož je to operace navíc, která nijak hodnotu nezmění

        return new Zlomek(novyCitatel, novyJmenovatel);
    }

    //nasobení opačným zlomek - při vstupu 5 budeme tedy násobit zlomkem 1/5 - jedna pětina
    public IZlomek vydel(int i) {
        int novyCitatel = getCitatel() /* *1 */;//1 nemá smysl násobit, nemění hodnotu je to jen operace navíc
        int novyJmenovatel = getJmenovatel() * i; //vytvoření opačného zlomku z 5/1 zapříčinilo to, že je 5 ve jmenovateli

        return new Zlomek(novyCitatel, novyJmenovatel);
    }


    public IZlomek secti(int i) {
        int novyCitatel = (getCitatel() /* *1*/) + (i * getJmenovatel()); //opět * 1 nemá smysl, zde se násobí vždy jmenovatelem druhého zlomku, abychom jej převedli na společného jmenovatele
        int novyJmenovatel = getJmenovatel() /* * 1*/;

        return new Zlomek(novyCitatel, novyJmenovatel);
    }

    public IZlomek odecti(int i) {
        int novyCitatel = (getCitatel() /* *1*/) - (i * getJmenovatel()); //stejné jak sčítání
        int novyJmenovatel = getJmenovatel() /* * 1*/;

        return new Zlomek(novyCitatel, novyJmenovatel);
    }
}
