public class KalkulatorModel {

    public double dodaj(double a, double b) {
        return a + b;
    }

    public double odejmij(double a, double b) {
        return a - b;
    }

    public double pomnoz(double a, double b) {
        return a * b;
    }

    public double podziel(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Dzielenie przez zero!");
        }
        return a / b;
    }
}

