public class AICar extends Car{
    @Override
    public void drive() {
        System.out.println("사람이 운전합니다.");
        System.out.println("사람이 방향을 전환합니다.");
    }
    
    @Override
    public void stop() {
        System.out.println("사람이 브레이크로 정지합니다.");
    }
}
