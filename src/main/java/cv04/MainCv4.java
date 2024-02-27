package cv04;

public class MainCv4 {
    public static void main(String[] args) {
        //parsování Stringu na Integer
        //mam zadný string s hodnotami (dejme tomu jakýši .csv soubor, kde delimiter pro jednotlivé hodnoty je ; (středník)
        //všimněte si, že některé hodnoty jsou celá čísla a některé písmena
        //též si všimněte, že nekterá čísla mají před nebo za mezeru (což je speciální typ znaku) -> též nebude možné převést na číslo
        String t = "2;8 ;-15; 6;10 ;g";

        //pokud vím, že hodnoty budou oddělené ; mohu zkontrolvoat zda daný vstup vůbec nějaké středníky obsahuje
        //pokud ne, nemusím ani zpracovávat protože jsem nedostal vhodný formát
        //pokud by csv měl pouze jednu hodnotu, nebylo by nutné delimiter použít, my však momentálně vyžadujeme seznam čísel a proto pro nás jedna hodnota není ideální > nebudeme zpracovávat
        boolean isValid = t.contains(";");
        if (isValid) {
            //pomocí metody split a parametru pro rozdělení řetězce mohu jednotlivé hodnoty, které rozdělením vznikly nahrát do pole Stringů
            //metoda tedy přijímá delimiter (případně celý regex výraz) a vrací pole stringů - jednotlivé hodnoty, které byli delimiterem oddělené
            String[] hodnotyString = t.split(";");
            //vytvořím nové pole integerů, do kterého chci všechny platné hodnoty nahrát > bude nutné je přetypovat na ing
            //vím, že pole určitě nebude větší než pole Stringů, proto můžu pro velikost pole použít velikost původního pole Stringů
            int[] hodnotyInt = new int[hodnotyString.length];

            //u pole integerů si budu hlídat obsazenost, abych pole obsazoval od začátku bez vynechání platnými hodnotami
            int obsazenost = 0;

            //všechny hodnoty ve stringovém poli projdu, abych je mohl jednu po jedné přetypovat a vložit do pole intů
            for (int i = 0; i < hodnotyString.length; i++) {
                try {
                    //před tím než budu hodnotu parsovat na int, raději odstraním možné mezery před a za čísly pomocí funkce trim(), kterou objekt String nabízí
                    String stringValue = hodnotyString[i].trim();
                    //po té zkusím hodnotu převést na int, pokud se to nepovede, bude vyhozena výjimka InvalidNumberFormatExeption
                    //z toho důvodu musím mít tento nebezpečný kód v try a v catch bloku zareagovat na chybu

                    int value = Integer.parseInt(stringValue);
                    hodnotyInt[obsazenost] = value;
                    obsazenost++;

                } catch (NumberFormatException e) { //v případě chyby ji odchytím a vypíšu hlášku do konzole, jaká hodnota nemohla být zpracována
                    System.out.println("Neplatná hodnota pro " + hodnotyString[i]);
                }
            }
        } else { //pokud neobsahoval vsutp žádný střední, nemohlo se jednat o výčet hodnot a proto považuji vstup za špatný
            System.out.println("Nezadal si platný formát dat");
        }

        //Přetěžování metody
        //na základě vstupu se rozlišuje, kterou metodu chci volat
        //pokud předám v parametru double, volá se metoda add, která přijímá a vrací double
        //a pokud předám int, volá se metoda, která přijimá a vrací int
        double d = add(2d, 3d);
        int i = add(2, 3);
    }


    //Metody na sečtení čísel, pokud pro jednu metodu existuje vícero implementací, mluvíme o tzv. přetěžováním metod
    //tyto metody se pak musejí lišit v parametrech (pořadí, datové typy), aby bylo jednoznačné, kterou metodu chceme volat
    public static double add(double p1, double p2) {
        return p1 + p2;
    }

    public static int add(int p1, int p2) {
        return p1 + p2;
    }


}
