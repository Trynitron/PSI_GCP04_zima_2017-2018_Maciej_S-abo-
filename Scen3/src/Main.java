
public class Main {
    public static void main(String[] args) {
        int[] structure = new int[] { 3, 20, 15, 10, 1 }; //budowa sieci (ilość wejść, ilość neuronów warstwie,(...),ilość wyjść)
        Trainer t = new Trainer(structure, 0.01f, 100000); //trener
        t.learn();  //uczenie
        t.test();   //testowanie
    }
}
