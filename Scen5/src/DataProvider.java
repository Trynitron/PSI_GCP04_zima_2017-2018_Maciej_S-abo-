import java.util.Random;

public class DataProvider {
    public static double[][] input = new double[][]{
            {0.6375, 0.4375, 0.175, 0.025},
            {0.6125, 0.375, 0.175, 0.025},
            {0.5875, 0.4, 0.1625, 0.025},
            {0.575, 0.3875, 0.1875, 0.025},
            {0.625, 0.45, 0.175, 0.025},
            {0.675, 0.4875, 0.2125, 0.05},
            {0.575, 0.425, 0.175, 0.0375},
            {0.625, 0.425, 0.1875, 0.025},
            {0.55, 0.3625, 0.175, 0.025},
            {0.6125, 0.3875, 0.1875, 0.0125},
            {0.675, 0.4625, 0.1875, 0.025},
            {0.6, 0.425, 0.2, 0.025},
            {0.6, 0.375, 0.175, 0.0125},
            {0.5375, 0.375, 0.1375, 0.0125},
            {0.725, 0.5, 0.15, 0.025},
            {0.7125, 0.55, 0.1875, 0.05},
            {0.675, 0.4875, 0.1625, 0.05},
            {0.6375, 0.4375, 0.175, 0.0375},
            {0.7125, 0.475, 0.2125, 0.0375},
            {0.6375, 0.475, 0.1875, 0.0375},
            {0.675, 0.425, 0.2125, 0.025},
            {0.6375, 0.4625, 0.1875, 0.05},
            {0.575, 0.45, 0.125, 0.025},
            {0.6375, 0.4125, 0.2125, 0.0625},
            {0.6, 0.425, 0.2375, 0.025},
            {0.625, 0.375, 0.2, 0.025},
            {0.625, 0.425, 0.2, 0.05},
            {0.65, 0.4375, 0.1875, 0.025},
            {0.65, 0.425, 0.175, 0.025},
            {0.5875, 0.4, 0.2, 0.025},
            {0.6, 0.3875, 0.2, 0.025},
            {0.675, 0.425, 0.1875, 0.05},
            {0.65, 0.5125, 0.1875, 0.0125},
            {0.6875, 0.525, 0.175, 0.025},
            {0.6125, 0.3875, 0.1875, 0.0125},
            {0.875, 0.4, 0.5875, 0.175},
            {0.8, 0.4, 0.5625, 0.1875},
            {0.8625, 0.3875, 0.6125, 0.1875},
            {0.6875, 0.2875, 0.5, 0.1625},
            {0.8125, 0.35, 0.575, 0.1875},
            {0.7125, 0.35, 0.5625, 0.1625},
            {0.7875, 0.4125, 0.5875, 0.2},
            {0.6125, 0.3, 0.4125, 0.125},
            {0.825, 0.3625, 0.575, 0.1625},
            {0.65, 0.3375, 0.4875, 0.175},
            {0.625, 0.25, 0.4375, 0.125},
            {0.7375, 0.375, 0.525, 0.1875},
            {0.75, 0.275, 0.5, 0.125},
            {0.7625, 0.3625, 0.5875, 0.175},
            {0.7, 0.3625, 0.45, 0.1625},
            {0.8375, 0.3875, 0.55, 0.175},
            {0.7, 0.375, 0.5625, 0.1875},
            {0.725, 0.3375, 0.5125, 0.125},
            {0.775, 0.275, 0.5625, 0.1875},
            {0.7, 0.3125, 0.4875, 0.1375},
            {0.7375, 0.4, 0.6, 0.225},
            {0.7625, 0.35, 0.5, 0.1625},
            {0.7875, 0.3125, 0.6125, 0.1875},
            {0.7625, 0.35, 0.5875, 0.15},
            {0.8, 0.3625, 0.5375, 0.1625},
            {0.825, 0.375, 0.55, 0.175},
            {0.85, 0.35, 0.6, 0.175},
            {0.8375, 0.375, 0.625, 0.2125},
            {0.75, 0.3625, 0.5625, 0.1875},
            {0.7125, 0.325, 0.4375, 0.125},
            {0.6875, 0.3, 0.475, 0.1375},
            {0.6875, 0.3, 0.4625, 0.125},
            {0.725, 0.3375, 0.4875, 0.15},
            {0.75, 0.3375, 0.6375, 0.2},
            {0.675, 0.375, 0.5625, 0.1875},
            {0.7875, 0.4125, 0.75, 0.3125},
            {0.725, 0.3375, 0.6375, 0.2375},
            {0.8875, 0.375, 0.7375, 0.2625},
            {0.7875, 0.3625, 0.7, 0.225},
            {0.8125, 0.375, 0.725, 0.275},
            {0.95, 0.375, 0.825, 0.2625},
            {0.6125, 0.3125, 0.5625, 0.2125},
            {0.9125, 0.3625, 0.7875, 0.225},
            {0.8375, 0.3125, 0.725, 0.225},
            {0.9, 0.45, 0.7625, 0.3125},
            {0.8125, 0.4, 0.6375, 0.25},
            {0.8, 0.3375, 0.6625, 0.2375},
            {0.85, 0.375, 0.6875, 0.2625},
            {0.7125, 0.3125, 0.625, 0.25},
            {0.725, 0.35, 0.6375, 0.3},
            {0.8, 0.4, 0.6625, 0.2875},
            {0.8125, 0.375, 0.6875, 0.225},
            {0.9625, 0.475, 0.8375, 0.275},
            {0.9625, 0.325, 0.8625, 0.2875},
            {0.75, 0.275, 0.625, 0.1875},
            {0.8625, 0.4, 0.7125, 0.2875},
            {0.7, 0.35, 0.6125, 0.25},
            {0.9625, 0.35, 0.8375, 0.25},
            {0.7875, 0.3375, 0.6125, 0.225},
            {0.8375, 0.4125, 0.7125, 0.2625},
            {0.9, 0.4, 0.75, 0.225},
            {0.775, 0.35, 0.6, 0.225},
            {0.7625, 0.375, 0.6125, 0.225},
            {0.8, 0.35, 0.7, 0.2625},
            {0.9, 0.375, 0.725, 0.2},
            {0.925, 0.35, 0.7625, 0.2375},
            {0.9875, 0.475, 0.8, 0.25},
            {0.8, 0.35, 0.7, 0.275},
            {0.7875, 0.35, 0.6375, 0.1875},
            {0.7625, 0.325, 0.7, 0.175}
    };

    public static double[][] testInput = new double[][]{
            {0.625, 0.4, 0.15, 0.025},
            {0.6875, 0.4375, 0.1625, 0.025},
            {0.6125, 0.3875, 0.1875, 0.0125},
            {0.55, 0.375, 0.1625, 0.025},
            {0.6375, 0.425, 0.1875, 0.025},
            {0.625, 0.4375, 0.1625, 0.0375},
            {0.5625, 0.2875, 0.1625, 0.0375},
            {0.55, 0.4, 0.1625, 0.025},
            {0.625, 0.4375, 0.2, 0.075},
            {0.6375, 0.475, 0.2375, 0.05},
            {0.6, 0.375, 0.175, 0.0375},
            {0.6375, 0.475, 0.2, 0.025},
            {0.575, 0.4, 0.175, 0.025},
            {0.6625, 0.4625, 0.1875, 0.025},
            {0.625, 0.4125, 0.175, 0.025},
            {0.75, 0.425, 0.5625, 0.2},
            {0.8375, 0.3875, 0.5875, 0.1875},
            {0.7875, 0.2875, 0.55, 0.1625},
            {0.7, 0.375, 0.5125, 0.1625},
            {0.6875, 0.3125, 0.5, 0.1625},
            {0.6875, 0.325, 0.55, 0.15},
            {0.7625, 0.375, 0.575, 0.175},
            {0.725, 0.325, 0.5, 0.15},
            {0.625, 0.2875, 0.4125, 0.125},
            {0.7, 0.3375, 0.525, 0.1625},
            {0.7125, 0.375, 0.525, 0.15},
            {0.7125, 0.3625, 0.525, 0.1625},
            {0.775, 0.3625, 0.5375, 0.1625},
            {0.6375, 0.3125, 0.375, 0.1375},
            {0.7125, 0.35, 0.5125, 0.1625},
            {0.9625, 0.375, 0.7625, 0.2875},
            {0.7875, 0.425, 0.7, 0.3},
            {0.8, 0.3875, 0.6875, 0.225},
            {0.75, 0.375, 0.6, 0.225},
            {0.8625, 0.3875, 0.675, 0.2625},
            {0.8375, 0.3875, 0.7, 0.3},
            {0.8625, 0.3875, 0.6375, 0.2875},
            {0.725, 0.3375, 0.6375, 0.2375},
            {0.85, 0.4, 0.7375, 0.2875},
            {0.8375, 0.4125, 0.7125, 0.3125},
            {0.8375, 0.375, 0.65, 0.2875},
            {0.7875, 0.3125, 0.625, 0.2375},
            {0.8125, 0.375, 0.65, 0.25},
            {0.775, 0.425, 0.675, 0.2875},
            {0.7375, 0.375, 0.6375, 0.225}
    };

    public static double[] getInput(int number, double[][] data) {
        double[] result = new double[input[0].length];

        for (int i = 0; i < result.length; i++) {
            result[i] = data[number][i];
        }
        return result;
    }

    public static void restoreInputToCorrectOrder() {
        double[][] correct = new double[][]{
                {0.6375, 0.4375, 0.175, 0.025},
                {0.6125, 0.375, 0.175, 0.025},
                {0.5875, 0.4, 0.1625, 0.025},
                {0.575, 0.3875, 0.1875, 0.025},
                {0.625, 0.45, 0.175, 0.025},
                {0.675, 0.4875, 0.2125, 0.05},
                {0.575, 0.425, 0.175, 0.0375},
                {0.625, 0.425, 0.1875, 0.025},
                {0.55, 0.3625, 0.175, 0.025},
                {0.6125, 0.3875, 0.1875, 0.0125},
                {0.675, 0.4625, 0.1875, 0.025},
                {0.6, 0.425, 0.2, 0.025},
                {0.6, 0.375, 0.175, 0.0125},
                {0.5375, 0.375, 0.1375, 0.0125},
                {0.725, 0.5, 0.15, 0.025},
                {0.7125, 0.55, 0.1875, 0.05},
                {0.675, 0.4875, 0.1625, 0.05},
                {0.6375, 0.4375, 0.175, 0.0375},
                {0.7125, 0.475, 0.2125, 0.0375},
                {0.6375, 0.475, 0.1875, 0.0375},
                {0.675, 0.425, 0.2125, 0.025},
                {0.6375, 0.4625, 0.1875, 0.05},
                {0.575, 0.45, 0.125, 0.025},
                {0.6375, 0.4125, 0.2125, 0.0625},
                {0.6, 0.425, 0.2375, 0.025},
                {0.625, 0.375, 0.2, 0.025},
                {0.625, 0.425, 0.2, 0.05},
                {0.65, 0.4375, 0.1875, 0.025},
                {0.65, 0.425, 0.175, 0.025},
                {0.5875, 0.4, 0.2, 0.025},
                {0.6, 0.3875, 0.2, 0.025},
                {0.675, 0.425, 0.1875, 0.05},
                {0.65, 0.5125, 0.1875, 0.0125},
                {0.6875, 0.525, 0.175, 0.025},
                {0.6125, 0.3875, 0.1875, 0.0125},
                {0.875, 0.4, 0.5875, 0.175},
                {0.8, 0.4, 0.5625, 0.1875},
                {0.8625, 0.3875, 0.6125, 0.1875},
                {0.6875, 0.2875, 0.5, 0.1625},
                {0.8125, 0.35, 0.575, 0.1875},
                {0.7125, 0.35, 0.5625, 0.1625},
                {0.7875, 0.4125, 0.5875, 0.2},
                {0.6125, 0.3, 0.4125, 0.125},
                {0.825, 0.3625, 0.575, 0.1625},
                {0.65, 0.3375, 0.4875, 0.175},
                {0.625, 0.25, 0.4375, 0.125},
                {0.7375, 0.375, 0.525, 0.1875},
                {0.75, 0.275, 0.5, 0.125},
                {0.7625, 0.3625, 0.5875, 0.175},
                {0.7, 0.3625, 0.45, 0.1625},
                {0.8375, 0.3875, 0.55, 0.175},
                {0.7, 0.375, 0.5625, 0.1875},
                {0.725, 0.3375, 0.5125, 0.125},
                {0.775, 0.275, 0.5625, 0.1875},
                {0.7, 0.3125, 0.4875, 0.1375},
                {0.7375, 0.4, 0.6, 0.225},
                {0.7625, 0.35, 0.5, 0.1625},
                {0.7875, 0.3125, 0.6125, 0.1875},
                {0.7625, 0.35, 0.5875, 0.15},
                {0.8, 0.3625, 0.5375, 0.1625},
                {0.825, 0.375, 0.55, 0.175},
                {0.85, 0.35, 0.6, 0.175},
                {0.8375, 0.375, 0.625, 0.2125},
                {0.75, 0.3625, 0.5625, 0.1875},
                {0.7125, 0.325, 0.4375, 0.125},
                {0.6875, 0.3, 0.475, 0.1375},
                {0.6875, 0.3, 0.4625, 0.125},
                {0.725, 0.3375, 0.4875, 0.15},
                {0.75, 0.3375, 0.6375, 0.2},
                {0.675, 0.375, 0.5625, 0.1875},
                {0.7875, 0.4125, 0.75, 0.3125},
                {0.725, 0.3375, 0.6375, 0.2375},
                {0.8875, 0.375, 0.7375, 0.2625},
                {0.7875, 0.3625, 0.7, 0.225},
                {0.8125, 0.375, 0.725, 0.275},
                {0.95, 0.375, 0.825, 0.2625},
                {0.6125, 0.3125, 0.5625, 0.2125},
                {0.9125, 0.3625, 0.7875, 0.225},
                {0.8375, 0.3125, 0.725, 0.225},
                {0.9, 0.45, 0.7625, 0.3125},
                {0.8125, 0.4, 0.6375, 0.25},
                {0.8, 0.3375, 0.6625, 0.2375},
                {0.85, 0.375, 0.6875, 0.2625},
                {0.7125, 0.3125, 0.625, 0.25},
                {0.725, 0.35, 0.6375, 0.3},
                {0.8, 0.4, 0.6625, 0.2875},
                {0.8125, 0.375, 0.6875, 0.225},
                {0.9625, 0.475, 0.8375, 0.275},
                {0.9625, 0.325, 0.8625, 0.2875},
                {0.75, 0.275, 0.625, 0.1875},
                {0.8625, 0.4, 0.7125, 0.2875},
                {0.7, 0.35, 0.6125, 0.25},
                {0.9625, 0.35, 0.8375, 0.25},
                {0.7875, 0.3375, 0.6125, 0.225},
                {0.8375, 0.4125, 0.7125, 0.2625},
                {0.9, 0.4, 0.75, 0.225},
                {0.775, 0.35, 0.6, 0.225},
                {0.7625, 0.375, 0.6125, 0.225},
                {0.8, 0.35, 0.7, 0.2625},
                {0.9, 0.375, 0.725, 0.2},
                {0.925, 0.35, 0.7625, 0.2375},
                {0.9875, 0.475, 0.8, 0.25},
                {0.8, 0.35, 0.7, 0.275},
                {0.7875, 0.35, 0.6375, 0.1875},
                {0.7625, 0.325, 0.7, 0.175}
        };
        System.arraycopy(correct, 0, DataProvider.input, 0, correct.length);
    }

    public static void randomise() {    //pomieszaj dane wejściowe
        int inputDataCount = input.length;
        int inputDataAttributionsCount = input[0].length;
        Random r = new Random();
        int place;

        double[] tmp = new double[inputDataAttributionsCount];
        for (int i = 0; i < inputDataCount; i++) {

            for (int j = 0; j < inputDataAttributionsCount; j++) {
                tmp[j] = input[i][j];
            }

            place = r.nextInt(inputDataCount - i) + i;


            for (int j = 0; j < inputDataAttributionsCount; j++) {
                input[i][j] = input[place][j];
            }

            for (int j = 0; j < inputDataAttributionsCount; j++) {
                input[place][j] = tmp[j];
            }
        }
    }
}
