
public class Neuron {
    double[] weights;

    public Neuron(double[] weights)                     //kopiuje dostarczoną tablicę wag
    {
        this.weights = new double[weights.length];
        System.arraycopy(weights, 0, this.weights, 0, weights.length);
    }

    public double calculateDistance(double[] input)    //liczy dystans neuronu od danych wejściowych
    {
        double sum = 0.0;
        for (int i = 0; i < input.length; i++) {
            sum += Math.pow((input[i] - weights[i]), 2);
        }
        sum += Math.pow((1 - weights[input.length]), 2);
        return Math.sqrt(sum);
    }

    public void updateWeights(double[] input, double lr)      //oblicza nowe wagi dla zwycięzcy
    {
        for (int i = 0; i < input.length; i++) {
            weights[i] += lr * (input[i] - weights[i]);
        }

        weights[input.length] += lr * (1 - weights[input.length]);
    }
}
