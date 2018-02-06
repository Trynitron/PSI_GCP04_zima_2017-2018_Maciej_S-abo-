public class Main {

    public static void main(String[] args) {
        Map m = new Map(0.001, 225, 10000);      //stworzenie mapy (learning rate, liczba neuronów, liczba cykli)
        m.learn();                          //nauczanie
        m.test(DataProvider.testInput);     //testowanie
        m.print(DataProvider.testInput); //wyświetlanie mapy dając dane testowe
    }
}
