public class Manager extends GeneralEmployee {

    public final double bonus = salary * 0.1;

    public Manager(int employeeId, String employeeName, int salary){
        super(employeeId, employeeName, salary);
    }

    @Override
    public int calcSalary() {
        return salary += bonus;
    }
}
