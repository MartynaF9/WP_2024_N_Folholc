public class DecoratorTest {
    public static void main(String[] args) {
        // Tworzymy zwykłą kawę
        Beverage coffee = new Coffee();
        System.out.println(coffee.getDescription() + " => " + coffee.cost() + " zł");

        // Dodajemy mleko
        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " => " + coffee.cost() + " zł");

        // Dodajemy kolejną warstwę dekoratora - czekoladę
        coffee = new ChocolateDecorator(coffee);
        System.out.println(coffee.getDescription() + " => " + coffee.cost() + " zł");
    }
}
