import java.util.Arrays;
import java.util.Random;

public class Map {
    private Neuron[] neuronMap;
    private int numberOfNeurons;
    private double lr;
    private double Max;

    public Map(double learningRate, int numberOfNeurons, int iter)      //tworzy tablicę neuronów i losuje początkowe wagi
    {
        this.Max = iter;
        this.numberOfNeurons = numberOfNeurons;
        lr = learningRate;
        neuronMap = new Neuron[this.numberOfNeurons];
        Random r = new Random();
        double[] weights = new double[DataProvider.input[0].length + 1];
        for (int j = 0; j < neuronMap.length; j++) {
            for (int i = 0; i < weights.length; i++) {
                weights[i] = r.nextDouble();
            }

            neuronMap[j] = new Neuron(weights);
        }
    }

    public void learn() {

        double lenght;
        double min;
        int counter = 0;
        int neuronNumber = 0;
        do {
            DataProvider.randomise();                                //miesza dane wejściowe
            for (int i = 0; i < DataProvider.input.length; i++)       //dla każdego rekordu
            {
                min = 0.0;
                for (int j = 0; j < neuronMap.length; j++)                  //szuka najbliższego neuronu
                {
                    double[] input = DataProvider.getInput(i, DataProvider.input);
                    lenght = neuronMap[j].calculateDistance(input);
                    if (lenght < min || j == 0) {
                        min = lenght;
                        neuronNumber = j;
                    }
                    neuronMap[neuronNumber].updateWeights(input, lr); //oblicza nowe wagi dla zwycięzcy
                }
            }
            counter++;
        } while (Max > counter);
        System.out.println("Counter=" + counter);
        DataProvider.restoreInputToCorrectOrder();
    }


    public void test(double[][] inputArray)                              //testowanie, wypisuje który neuron ile razy został aktywowany
    {
        int neuronNumber;
        int[] responseCounter = new int[neuronMap.length];
        Arrays.fill(responseCounter, 0);
        for (int i = 0; i < inputArray.length; i++) {
            double[] input = DataProvider.getInput(i, inputArray);
            neuronNumber = setClass(input);
            responseCounter[neuronNumber]++;
        }
        int n;
        for (int i = 0; i < responseCounter.length; i++) {
            n = responseCounter[i];
            if (n != 0)
                System.out.println("Neuron: " + i + " Count: " + n);
        }
    }

    public void print(double[][] inputArray) {
        int size = inputArray.length / 3;
        int mapS = (int) Math.sqrt(numberOfNeurons);
        int beg = 0;
        int end = size;
        String[] map = new String[numberOfNeurons];
        for (int i = 0; i < map.length; i++) {
            map[i] = "";
        }

        map = calculate(map, beg, end, "1", inputArray);
        beg += size;
        end += size;
        map = calculate(map, beg, end, "2", inputArray);
        beg += size;
        end += size;
        map = calculate(map, beg, end, "3", inputArray);

        for (int i = 0; i < mapS; i++) {
            for (int j = 0; j < mapS; j++) {
                int k = i * mapS + j;
                if (map[k] == "") {
                    System.out.print("#\t\t");
                } else {
                    System.out.print(map[k] + "\t\t");
                }
            }
            System.out.println();
        }
    }

    private String[] calculate(String[] map, int beg, int end, String type, double[][] inputArray) //metoda do jakie dane aktywuje neuron
    {
        int nn;
        for (int i = beg; i < end; i++) {
            double[] input = DataProvider.getInput(i, inputArray);
            nn = setClass(input);
            map[nn] += type;
        }
        return map;
    }


    private int setClass(double[] input)       //który neuron jest aktywowany dla danego inputu
    {
        int classification = 0;
        double lenght;
        double min = 0.0;
        for (int j = 0; j < neuronMap.length; j++) {
            lenght = neuronMap[j].calculateDistance(input);
            if (lenght < min || j == 0) {
                min = lenght;
                classification = j;
            }
        }
        return classification;
    }
}