public class Coffee implements Beverage {
    @Override
    public String getDescription() {
        return "Kawa";
    }

    @Override
    public double cost() {
        return 5.0; // bazowa cena kawy
    }
}

