import java.util.Arrays;
import java.util.Random;

public class Trainer {
    private Neuron[] layer;
    private double learningRate;
    private int Max = 1000;
    private double decay;
    private boolean teacherFlag;
    int counter;

    public Trainer(int numberOfNeurons, double learningRate, double decay, boolean shouldLearningBeSupervised) {
        this.learningRate = learningRate;
        this.decay = decay;
        this.teacherFlag = shouldLearningBeSupervised;
        layer = new Neuron[numberOfNeurons];

        Random r = new Random();
        double[] weights = new double[DataProvider.nFields];

        for (int i = 0; i < numberOfNeurons; i++) {
            for (int j = 0; j < weights.length; j++) {
                weights[j] = r.nextDouble();
            }
            layer[i] = new Neuron(weights);
        }
    }

    public boolean train() {    //uczenie zależne od tego czy z nauczycielem czy bez
        this.counter = 0;

        if (this.teacherFlag) {
            supervised();
        } else {
            unsupervisedLearning();
        }
        if (counter == Max) {
            System.out.println("Nie udało się nauczyć");
            return false;
        }
        System.out.println("Epoki: " + this.counter);
        return true;
    }

    public int act(double[] input) {    //sprawdzanie który neuron zeragował na którą emotikonę
        int winner = 0;
        double result;
        double winnerResult = layer[0].getResult(input);
        for (int i = 1; i < layer.length; i++) {
            result = layer[i].getResult(input);
            if (winnerResult < result) {
                winner = i;
                winnerResult = result;
            }
        }
        return winner;
    }

    private void supervised() { //uczenie z nauczycielem zgodnie ze sprawozdaniem
        this.counter = 0;
        double[] input;
        double expected;
        double[] winners = new double[layer.length];
        do {
            for (int i = 0; i < DataProvider.expected.length; i++) { //dla wszystkich emotikon
                input = DataProvider.getData(i, DataProvider.correct);  //pobiera dane wejściowe z providera
                for (int j = 0; j < layer.length; j++) {    //dla każdego neruonu
                    if (i == j) {   //jeżeli id neuronu == id emotikony neuron powinien na nią zaregować, w przeciwnym razie powinien nie zostać wzbudzony
                        expected = 1;
                    } else {
                        expected = 0;
                    }
                    layer[j].learn(input, expected, this.learningRate, this.decay); //uczenie neuronu
                }
                for (int j = 0; j < layer.length; j++) {
                    input = DataProvider.getData(j, DataProvider.correct);
                    winners[j] = act(input);    //sprawdzanie czy na daną emotikonę zareagował tylko jeden neuron
                }
            }
            this.counter++;
        } while (this.counter < Max && Arrays.stream(winners).distinct().count() != winners.length);    //drugi warunek sprawdza czy każdy neuron reaguje na różną emotikonę
    }

    private void unsupervisedLearning() {   //uczenie bez nauczyciela zgodnie ze sprawozdaniem
        this.counter = 0;
        double[] input;
        double result;
        double[] winners = new double[layer.length];
        do {
            for (int i = 0; i < DataProvider.expected.length; i++) {
                input = DataProvider.getData(i, DataProvider.correct);
                for (int j = 0; j < layer.length; j++) {
                    result = layer[j].getResult(input);
                    layer[j].learn(input, result, this.learningRate, this.decay);
                }
                for (int j = 0; j < layer.length; j++) {
                    input = DataProvider.getData(j, DataProvider.correct);
                    winners[j] = act(input);
                }
            }
            this.counter++;
        } while (this.counter < Max && Arrays.stream(winners).distinct().count() != winners.length);
        for (int j = 0; j < layer.length; j++) {
            input = DataProvider.getData(j, DataProvider.correct);
            winners[j] = act(input);
        }
    }

    public void test(double[][][] dataSet) {    //testowanie neuronów czy zwracają wartości oczekiwane na dane emotikony (czy odpowiednie neurony zostały aktywowane)
        double[] input;
        int[] winners = new int[layer.length];
        int errors = 0;
        String expected, got;
        for (int j = 0; j < layer.length; j++) {
            input = DataProvider.getData(j, DataProvider.correct);
            winners[j] = act(input);
        }
        for (int i = 0; i < dataSet.length; i++) {
            input = DataProvider.getData(i, dataSet);
            expected = DataProvider.emoticons[winners[i % DataProvider.emoticons.length]];
            got = DataProvider.emoticons[act(input)];
            System.out.println("Emotikona nr " + (i + 1) + ". Exp: " + expected + " Got: " + got);
            if (!DataProvider.emoticons[act(input)].equals(DataProvider.emoticons[winners[i % DataProvider.emoticons.length]])) {
                errors++;
            }
        }
        System.out.println("Errors: " + errors);
    }
}
