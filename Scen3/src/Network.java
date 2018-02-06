
public class Network {
    Layer[] layers;
    float learningRate;

    public Network(int[] layer, float learningRate) {       //tworzenie sieci
        this.learningRate = learningRate;

        layers = new Layer[layer.length - 1];

        for (int i = 0; i < layers.length; i++) {
            layers[i] = new Layer(layer[i], layer[i + 1]);
        }
    }

    public float[] forward(float[] inputs) {    //algorytm feedforward
        layers[0].forward(inputs);  //zaczynamy od pierwszej warstwy (jako input przyjmuje input sieci)
        for (int i = 1; i < layers.length; i++) {
            layers[i].forward(layers[i - 1].outputs);   //każda kolejna warstwa jako dane wejściowe przyjmuje dane wyjściowe warstwy poprzedniej
        }

        return layers[layers.length - 1].outputs;   //zwracamy dane wyjściowe ostatniej warstwy jako wynik sieci
    }

    public void backPropagation(float[] expected) { //algorytm backPropagation
        for (int i = layers.length - 1; i >= 0; i--) { //zgodnie ze sprawozdaniem mamy dwie różne możliwości
            if (i == layers.length - 1) {   //jeżeli znajdujemy się w warstwie ostatniej
                layers[i].backPropOutput(expected);
            } else {    //jeżeli znajdujemy się w każdej innej warstwie
                layers[i].backPropHidden(layers[i + 1].gamma, layers[i + 1].weights);
            }
        }

        for (int i = 0; i < layers.length; i++) { //po przejściu wstecz aktualizujemy wszystkie warstwy o nowe wagi
            layers[i].updateWeights(learningRate);
        }
    }
}
