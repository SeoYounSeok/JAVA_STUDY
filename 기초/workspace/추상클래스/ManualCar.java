public class ManualCar {
    @Override
    public void drive() {
        System.out.println("자율 주행 합니다.");
        System.out.println("알아서 합니다.");
    }
    
    @Override
    public void stop() {
        System.out.println("장애물을 발견하여, 정지합니다.");
    }
}
