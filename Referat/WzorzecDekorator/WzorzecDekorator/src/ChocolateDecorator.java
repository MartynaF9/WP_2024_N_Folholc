public class ChocolateDecorator extends BeverageDecorator {

    public ChocolateDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " + czekolada";
    }

    @Override
    public double cost() {
        return beverage.cost() + 2.0;
    }
}
