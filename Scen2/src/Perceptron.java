
public class Perceptron {
    private double[] weights;

    public Perceptron(double[] weights) {   //ustawia wagi
        this.weights = new double[weights.length];
        System.arraycopy(weights, 0, this.weights, 0, weights.length);
    }

    public double getResult(int[] input) { //zwraca wynik perceptronu funkcjaAktywacji(suma)
        double sum = sum(input);
        return actFun(sum);
    }

    public void learn(int[] input, double expected, double lr) { //nauka perceptronu zgodnie ze sprawozdaniem
        double result = getResult(input);   //wynik perceptronu
        double delta = expected - result;   //różnica między oczekiwana - wynik

        double error = delta * div(sum(input)); //obliczanie błędu (różnica*funkcja aktywacji)

        for (int i = 0; i < input.length; i++)
            weights[i] += error * lr * input[i];    //aktualizacja wag

        weights[Letters.nFields] += lr * error; //aktualizacjia BIAS-u
    }

    private double sum(int[] input) {   //sumowanie wag*wejście
        double sum = 0;
        for (int i = 0; i < input.length; i++) {    //pętla po wejściach
            sum += weights[i] * input[i];
        }

        double bias = 1;
        return sum + weights[input.length] * bias;  //dodanie biasu
    }

    private double actFun(double sum) {
        return 1 / (1 + Math.exp(-sum));
    } //funkcja aktywacji

    private double div(double x) {
        return Math.exp(-x) / Math.pow((Math.exp(-x) + 1), 2);
    }   //pochodna funkcji aktywacji
}
