public abstract class BeverageDecorator implements Beverage {
    // Kompozycja: przechowujemy referencję do obiektu "Beverage"
    protected Beverage beverage;

    public BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    // Opcjonalnie możemy zdefiniować podstawową implementację metod
    // lub zostawić je abstrakcyjne. 
    @Override
    public String getDescription() {
        return beverage.getDescription();
    }

    @Override
    public double cost() {
        return beverage.cost();
    }
}
