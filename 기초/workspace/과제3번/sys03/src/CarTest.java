public class CarTest {

	public static void main(String[] args) {

		CarFactory company = CarFactory.getInstance();  //싱글톤 패턴
		
		Car myCar = company.createCar();   //메서드에서 Car 생성
		Car yourCar = company.createCar();
		
		System.out.println(myCar.getCarNumber());    //10001  출력
		System.out.println(yourCar.getCarNumber());  //10002  출력
		
	    }
}
