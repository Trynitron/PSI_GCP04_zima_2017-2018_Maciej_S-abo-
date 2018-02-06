public class Main {

    public static void main(String[] args) {
        double learningRate = 0.5;
        double decay = 0.01; //współczynnik zapominania
        int numberOfNeurons = 4;
        Trainer trainer = new Trainer(numberOfNeurons, learningRate, decay, true);
        if (trainer.train()) {
            System.out.println("Testowanie nauki na danych do nauki");
            trainer.test(DataProvider.correct);
            System.out.println("Testowanie nauki na danych zaszumionych");
            trainer.test(DataProvider.corrupted);
        }
    }
}
