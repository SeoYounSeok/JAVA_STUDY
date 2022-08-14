public class Engineer extends GeneralEmployee {

    public final double bonus = salary * 0.2;

    public Engineer(int employeeId, String employeeName, int salary){
        super(employeeId, employeeName, salary);
    }

    @Override
    public int calcSalary() {
        return salary += bonus;
    }
}
