public class SalesManager implements Employee
{
    private String name;   // имя
    private Proff profession; // професссия
    private double salary; // зарплата

    static SalesManager getInstance(String name)
    {
        return new SalesManager(name,(double)Math.round(Math.random() * 50000000)/100 + 1000000);
    }

    private SalesManager(String name,double money)// конструктор
    {
        this.name = name;
        this.profession = Proff.SALES_MANAGER;
        this.salary = initSalary(money);
    }

    @Override // Домашнее задание
    public double getMonthSalary() {
        return salary;
    }

    private double initSalary(double money)
    {
        double fix, bonus;
        fix = (double)Math.round(Math.random() * 2500000)/100 + 25000;
        bonus = money * 0.05;
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
