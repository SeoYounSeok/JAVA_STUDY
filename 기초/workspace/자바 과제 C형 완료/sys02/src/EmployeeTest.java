import java.util.ArrayList;

public class EmployeeTest {

	public static void main(String[] args) {

		int salary = 500;
		ArrayList<GeneralEmployee> list = new ArrayList<GeneralEmployee>();
		list.add(new GeneralEmployee(1001, "James", salary));
		list.add(new Manager(1002, "Tomas", salary));
		list.add(new Engineer(1003, "Edward", salary));
		
		for(GeneralEmployee employee : list) {
			System.out.println(employee.employeeName + "님의 업무는 " + 
					employee.work() + " 분야 이며, 월급은 " + employee.calcSalary() + "만원 입니다.");
			
		}
	}
}