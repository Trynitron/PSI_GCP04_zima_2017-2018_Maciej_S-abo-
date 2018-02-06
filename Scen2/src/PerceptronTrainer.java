import java.util.Random;

public class PerceptronTrainer {
    private Perceptron[] layer; //ilość neuronów (każdy neuron powinien rozpoznawać jeden typ [duża,mała])
    private double learningRate;
    private final int maxEpoch = 1000000; //maksymalna liczba epok

    public PerceptronTrainer(int numberOfPerceptrons, double learningRate) {    //konstruktor(liczba neuronów, lr)
        this.learningRate = learningRate;
        layer = new Perceptron[numberOfPerceptrons];

        Random r = new Random();                                //losowanie wag i inicjalizacja neuronów
        double[] weights = new double[Letters.nFields + 1];

        for (int i = 0; i < numberOfPerceptrons; i++) {
            for (int j = 0; j < weights.length; j++) {
                weights[j] = r.nextDouble();
            }
            layer[i] = new Perceptron(weights);
        }
    }

    public void train() {   //funckcja ucząca neurony
        int counter = 0;    //licznik epok
        int[] input;    //wejście
        int expected;   //wartość oczekiwana
        double result;  //wynik neuronu
        double mseError;    //błąd średniokwadratowy
        do {
            mseError = 0.0;
            for (int i = 0; i < Letters.expected.length; i++) { //dla każdej litery
                for (int j = 0; j < layer.length; j++) {   //dla każdego neuronu
                    input = Letters.getLetter(i, Letters.correct); //litera z providera jako tablica
                    expected = getExpected(Letters.expected[i], j); //sprawdza czego powinien oczekiwać dla którego neuronu (neuron 1 powinien oczekiwać odwrotnej wartości niż neuron 2)
                    layer[j].learn(input, expected, learningRate); //uczenie
                    result = layer[j].getResult(input); //weź wynik z uczenia
                    mseError += Math.pow((expected - result), 2.0); //oblicz błąd średniokwadratowy
                }
            }
            counter++;  //zwiększ licznik epok
        } while (counter < maxEpoch && mseError > 0.001); //warunek zakończenia uczenia
    }

    public void test(int[][][] data) {   //testowanie data - litery poprawne lub zaszumione
        double correctAnswers = Letters.expected.length;  //ilość poprawnych wyników (na początku max)
        int[] input;
        int expected;
        for (int i = 0; i < Letters.expected.length; i++) { //dla wszystkich liter
            input = Letters.getLetter(i, data);
            expected = Letters.expected[i];

            if (act(input) != expected)     //sprawdza czy otrzymał wartość oczekiwaną
                correctAnswers--; //jeśli nie to zmniejsza ilość poprawnych wyników

            if (act(input) == 1) {
                System.out.print("d ");
            } else {
                System.out.print("m ");
            }
            System.out.println(Letters.letter[i]);
        }
        System.out.println("Procent: " + correctAnswers / 20 * 100 + "%");
    }

    private int getExpected(int expected, int nr) { //zwraca wartość oczekiwaną
        if (nr == 0) {
            return expected;
        } else if (expected > 0) {
            return 0;
        }

        return 1;
    }

    public int act(int[] input) {   //zwraca wynik, który neuron powinien być aktywowany
        if (layer[0].getResult(input) > layer[1].getResult(input)) {
            return 1;
        } else {
            return 0;
        }
    }
}
