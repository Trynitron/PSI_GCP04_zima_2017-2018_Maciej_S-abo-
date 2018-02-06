
public class Trainer {
    private Network network;
    private int Max;

    public Trainer(int[] neuralStructure, float learningRate, int max) {
        network = new Network(neuralStructure, learningRate);
        Max = max;
    }

    public void learn() {   //algorytm uczenia
        int counter = 0;    //ilość epok
        double mseError = 0.0f;
        do {
            mseError = 0.0f;  //błąd średniokwadratowy
            for (float x = -2; x <= 2; x += 0.5f) { // x i y jako dane wejściowe dla obliczenia wartości funkcji oraz do nauki sieci
                for (float y = -2; y <= 2; y += 0.5f) {
                    float expected = (float) ((DataProvider.calculateResult(x, y) + 50) / 100); //obliczanie wartości funkcji w punkcjie x,y oraz normalizacja do przedziału 0,1
                    float output = network.forward(new float[]{x, y, 1})[0]; //wynik sieci
                    mseError += Math.pow(output - expected, 2); //błąd średniokwadratowy
                    network.backPropagation(new float[]{expected}); //algorytm propagacji wstecznej z wyniku
                }
            }

            if (counter % (Max / 10) == 0) { //co 10% epok z maksymalnej ilości epok
                //System.out.println("Error: " + mseError);
                System.out.println("Error: " + mseError + " Counter: " + counter);
                test();
            }
            counter++;  //zwiększanie liczby epok
        } while (counter < Max && mseError > 0.000001);
        System.out.println("Error: " + mseError + " Counter: " + counter);
    }

    public void test() {    //testowanie podobne jak uczenie tylko nie zawiera algorytmów propagacji, zamiast tego tylko porównuje wyniki otrzymane z oczekiwanymi
        float error = 0.0f;
        int iterator = 0;
        for (float x = -2; x <= 2; x += 1f) {
            for (float y = -2; y <= 2; y += 1f) {
                float result = network.forward(new float[]{x, y, 1})[0];
                float expected = (float) ((DataProvider.calculateResult(x, y)));
                System.out.println(x + " " + y + " Got: " + (result * 100 - 50) + " Expected: " + expected);
                iterator++;
                error += Math.abs((result * 100 - 50) - expected);
            }
        }
        System.out.println("Prawdziwy blad sredni: " + (error / (float) iterator));
    }
}
