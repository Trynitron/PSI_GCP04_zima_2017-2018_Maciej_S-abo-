
public class Main {

    public static void main(String[] args) {
        double learningRate = 0.1;

        System.out.println("Perceptron");
        PerceptronTrainer trainer = new PerceptronTrainer(2, learningRate);     //tworzy trenera z 2 perceptronami
        trainer.train();    //trenuje
        System.out.println("Testowanie poprawnych");
        trainer.test(Letters.correct);      //testowanie na danych wejściowych
        System.out.println("Testowanie zaszumionych");
        trainer.test(Letters.corrupted);        //testowanie danych zaszumionych

        System.out.println("Adaline");
        AdalineTrainer aTrainer = new AdalineTrainer(learningRate); //tworzy trenera adaline z 2 neuronami adaline
        aTrainer.train();   //trenuje
        System.out.println("Testowanie poprawnych");
        aTrainer.test(Letters.correct); //testowanie na danych wejściowych
        System.out.println("Testowanie zaszumionych");
        aTrainer.test(Letters.corrupted);       //na danych zaszumionych

    }
}
