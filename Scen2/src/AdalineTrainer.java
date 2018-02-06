import java.util.Random;

public class AdalineTrainer {
    private Adaline[] layer;
    private double learningRate;

    public AdalineTrainer(double learningRate) {
        this.learningRate = learningRate;
        int biasID = Letters.nFields;
        int numberOfNeurons = 2;
        layer = new Adaline[numberOfNeurons];
        double[] results = new double[numberOfNeurons];

        Random r = new Random();
        double[] weights = new double[Letters.nFields + 1];

        for (int i = 0; i < numberOfNeurons; i++)
        {
            for (int j = 0; j < weights.length; j++)
            {
                weights[j] = r.nextDouble();
            }
            layer[i] = new Adaline(weights);
        }
    }

    public void train() {
        int counter = 0;
        int[] input;
        int expected;
        double result;
        double mseError;
        int max = 100000000;
        do
        {
            mseError = 0.0;
            for (int i = 0; i < Letters.expected.length; i++)
            {
                for (int j = 0; j < 2; j++)
                {
                    input = Letters.getLetter(i, Letters.correct);
                    expected = getExpected(Letters.expected[i], j);
                    layer[j].learn(input, expected, learningRate);
                    result = layer[j].getResult(input);
                    mseError += Math.pow((expected - result), 2.0);
                }
            }
            counter++;
        } while (counter < max && mseError > 0.001);
        System.out.println(counter);
    }

    public void test(int[][][] letters) {
        double rate = Letters.expected.length;
        int[] input;
        int expected;
        for (int i = 0; i < Letters.expected.length; i++)
        {
            input = Letters.getLetter(i, letters);
            expected = Letters.expected[i];

            if (act(input) != expected)
                rate--;

            if (act(input) == 1)
            {
                System.out.print("d ");
            }
            else
            {
                System.out.print("m ");
            }

            System.out.println(Letters.letter[i]);
        }
        System.out.println("Poprawne odpowiedzi: " + rate / 20 * 100 + "%");
    }

    private int getExpected(int expected, int nr) {
        if (nr == 0)
        {
            if (expected == 0)
                return -1;
            return expected;
        }
        else if (expected > 0)
        {
            return -1;
        }

        return 1;
    }

    public int act(int[] input) {
        if (layer[0].getResult(input) > layer[1].getResult(input))
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}
