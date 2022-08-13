public class GenericPrinterTest {
    public static void main(String[] args) {
        GenenricPrinter<Powder> powderPrinter = new GenenricPrinter<Powder>();
        powderPrinter.setMaterial(new Powder());
        System.out.println(powderPrinter); // toString 자동 탑재

        GenenricPrinter<Plastic> plasticPrinter = new GenenricPrinter<Plastic>();
        plasticPrinter.setMaterial(new Plastic());
        System.out.println(plasticPrinter);

        GenenricPrinter<Water> waterPrinter = new GenenricPrinter<Water>();
        waterPrinter.setMaterial(new Water());
        System.out.println(waterPrinter);

    }
}
