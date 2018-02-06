
public class Neuron {
    private double[] weights;
    private double bias = 0.5;

    public Neuron(double[] weights) {   //inicjalizacja
        this.weights = new double[weights.length];
        System.arraycopy(weights, 0, this.weights, 0, weights.length);
    }

    public double getResult(double[] input) {   //wyniki
        double sum = sum(input);
        return actFun(sum);
    }

    public void learn(double[] input, double output, double lr, double decay) { //algorytm uczenia zgodnie ze sprawozdaniem
        for (int i = 0; i < input.length; i++) {
            weights[i] = ((1 - decay) * weights[i] + lr * output * input[i]);

        }
        bias = ((1 - decay) * bias + lr * output);
        normalize();
    }

    private double sum(double[] input) {    //sumowanie wag*dane wejściowe
        double sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += weights[i] * input[i];
        }

        return sum + bias;
    }

    private double actFun(double sum) {
        return 1 / (1 + Math.exp(-sum));
    }   //funkcja aktywacji

    private void normalize() {  //normalizowanie wag (tak aby nie były zbyt duże)
        double dl = 0.0;
        for (int i = 0; i < weights.length; i++)
            dl += Math.pow(weights[i], 2);

        dl = Math.sqrt(dl);

        for (int i = 0; i < weights.length; i++)
            if (weights[i] > 0 && dl != 0)
                weights[i] = weights[i] / dl;
        if (dl != 0)
            bias = bias / dl;
    }
}
