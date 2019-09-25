public class TopManager implements Employee
{
    private String name;   // имя
    private Proff profession; // професссия
    private double salary; // зарплата

    static TopManager getInstance(String name, double money)
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

    private double initSalary(double money) {
        double fix, bonus;
        fix = (double)Math.round(Math.random() * 3000000)/100 + 150000;
        bonus = (money > 10000000) ?  50000 :  0;
        return fix + bonus;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getProfession() {
        return profession.name;
    }
    @Override
    public String toString()
    {
        return String.format("%-13s%-22s",getName(),getProfession());
    }
}
