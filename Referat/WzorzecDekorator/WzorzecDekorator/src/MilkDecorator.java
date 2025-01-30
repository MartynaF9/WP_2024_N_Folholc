public class MilkDecorator extends BeverageDecorator {

    public MilkDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        // Rozszerzamy opis bazowy
        return beverage.getDescription() + " + mleko";
    }

    @Override
    public double cost() {
        // Dodajemy koszt mleka do bazowego kosztu
        return beverage.cost() + 1.0;
    }
}
