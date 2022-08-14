public class GeneralEmployee {
    protected int employeeId;
    protected String employeeName;
    protected int salary;
    
    public GeneralEmployee(int employeeId, String employeeName, int salary){
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
    }

    public String work() {
        return this.getClass().getName();
    }

    public int calcSalary() {
        return salary;
    }
}
