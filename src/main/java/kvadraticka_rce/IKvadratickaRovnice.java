package kvadraticka_rce;

//4) Vytvořte interface pro kvadratickou rovnici, který bude mít metody vypoctiDiskriminant, vypoctiKoreny (určete správné datové typy)
public interface IKvadratickaRovnice {
    double vypoctiDiskriminant(); //diskriminant je reálné číslo

    double[] vypoctiKoreny(); //kořenů může být více, proto pole doublů,


    // případně je možné si vytvořit třídu přímo pro kořeny - alternativní řešení
    Koreny vypociKoreny();
}
