
public class Adaline {
    private double[] weights;
    private double bias = 1;

    public Adaline(double[] weights) {  //konstruktor kopiuje wagi neuronu
        this.weights = new double[weights.length];
        System.arraycopy(weights, 0, this.weights, 0, weights.length);
    }

    public double getResult(int[] input) {
        return sum(input);
    }   //zwraca wynik

    private double sum(int[] input) { //suma wag * wejście
        double sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += weights[i] * input[i];
        }

        return sum + weights[input.length] * bias;
    }

    private double actFun(double sum) {
        return 1 / (1 + Math.exp(sum));
    } //funkcja aktywacji zgodna ze wzorem w sprawozdaniu

    public void learn(int[] input, double expected, double lr) { //nauka zgodnie ze wzorem w sprawozdaniu
        double result = getResult(input);

        for (int i = 0; i < input.length; i++)
            weights[i] += (expected - result) * lr * input[i];

        weights[Letters.nFields] += lr * (expected - result);
    }
}
