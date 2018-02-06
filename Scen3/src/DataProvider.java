
public class DataProvider {
    public static double calculateResult(double x, double y) { //wartość funkcji dla podanego x,y
        return 20 + Math.pow(x, 2) + Math.pow(y, 2) - 10 * (Math.cos(2 * Math.PI * x) + Math.cos(2 * Math.PI * y));
    }
}
