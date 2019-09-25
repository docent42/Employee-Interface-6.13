public class TopManager extends Employee
{
    private double salary;

    public static TopManager getInstance(String name, double money)
    {
        return new TopManager(name,money);
    }

    private TopManager(String name,double money)
    {
        this.name = name;
        this.profession = Proff.TOP_MANAGER;
        this.salary = initSalary(money);
    }

    @Override
    public double getMonthSalary() {
        return salary;
    }

    @Override
    double initSalary(double money) {
        double fix, bonus;
        fix = (double)Math.round(Math.random() * 3000000)/100 + 150000;
        bonus = (money > 10000000) ?  50000 :  0;
        return fix + bonus;
    }


    @Override
    public int compareTo(Employee o) {
        return Double.compare(getMonthSalary(),o.getMonthSalary()) ;
    }
}
