public class Car {
    private static int initNum = 10000;
    private int carNumber;

    public Car() {
        initNum += 1;
        carNumber = initNum;
    }

    public int getCarNumber() {
        return carNumber;
    }    
}
