public class CarFactory {
    private static CarFactory factory;

    public static CarFactory getInstance() {
        factory = new CarFactory();
        return factory;
    }

    public Car createCar() {
        return new Car();
    }
}
