public class Operator extends Employee
{
    private double salary;

    public static Operator getInstance(String name)
    {
        return new Operator(name,0);
    }

    private Operator(String name,double money)
    {
        this.name = name;
        this.profession = Proff.OPERATOR;
        this.salary = initSalary(money);
    }

    @Override
    public double getMonthSalary() {
        return salary;
    }

    @Override
    double initSalary(double money) {
        return (double)Math.round(Math.random() * 2500000)/100 + 25000;
    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare(getMonthSalary(),o.getMonthSalary()) ;
    }
}
