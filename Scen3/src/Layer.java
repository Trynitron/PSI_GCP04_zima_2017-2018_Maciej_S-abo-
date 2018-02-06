import java.util.Random;

public class Layer {
    int nIn;
    int nOut;

    public float[] outputs;
    public float[] inputs;
    public float[][] weights;
    public float[][] weightsDelta;
    public float[] gamma;
    public float[] error;

    public static Random random = new Random();

    public Layer(int numberOfInputs, int numberOfOuputs) {
        this.nIn = numberOfInputs;
        this.nOut = numberOfOuputs;

        outputs = new float[numberOfOuputs];
        inputs = new float[numberOfInputs];
        weights = new float[numberOfOuputs][numberOfInputs];
        weightsDelta = new float[numberOfOuputs][numberOfInputs];
        gamma = new float[numberOfOuputs];
        error = new float[numberOfOuputs];

        initWeights();
    }

    public void initWeights() {     //inicjalizacja wag
        for (int i = 0; i < nOut; i++) {
            for (int j = 0; j < nIn; j++) {
                weights[i][j] = (float) random.nextDouble() - 0.5f; //losowa liczba od -0.5 do 0.5
            }
        }
    }

    public float[] forward(float[] inputs) {    //do przodu, obliczanie wyniku z warstwy na podstawie wejścia
        this.inputs = inputs;

        for (int i = 0; i < nOut; i++) {
            outputs[i] = 0;
            for (int j = 0; j < nIn; j++) {
                outputs[i] += inputs[j] * weights[i][j];
            }

            outputs[i] = (float) Math.tanh(outputs[i]);
        }

        return outputs;
    }

    public float div(float value) {
        return 1 - (value * value);
    } //pochodna funkcji aktywacji

    public void backPropOutput(float[] expected) {  //algorytm propagacji wstecznej dla ostatniej warstwy zgodnie ze sprawozdaniem
        for (int i = 0; i < nOut; i++)
            error[i] = outputs[i] - expected[i];

        for (int i = 0; i < nOut; i++)
            gamma[i] = error[i] * div(outputs[i]);

        for (int i = 0; i < nOut; i++) {
            for (int j = 0; j < nIn; j++) {
                weightsDelta[i][j] = gamma[i] * inputs[j];
            }
        }
    }

    public void backPropHidden(float[] gammaForward, float[][] weightsFoward) { //algorytm propagacji wstecznej dla każdej kolejnej warstwy poza pierwszą zgodnie ze sprawozdaniem
        for (int i = 0; i < nOut; i++) {
            gamma[i] = 0;

            for (int j = 0; j < gammaForward.length; j++) {
                gamma[i] += gammaForward[j] * weightsFoward[j][i];
            }

            gamma[i] *= div(outputs[i]);
        }

        for (int i = 0; i < nOut; i++) {
            for (int j = 0; j < nIn; j++) {
                weightsDelta[i][j] = gamma[i] * inputs[j];
            }
        }
    }

    public void updateWeights(float learningRate) { //aktualizacja wag (wywoływana po algorytmie propagacji wstecznej
        for (int i = 0; i < nOut; i++) {
            for (int j = 0; j < nIn; j++) {
                weights[i][j] -= weightsDelta[i][j] * learningRate;
            }
        }
    }
}
